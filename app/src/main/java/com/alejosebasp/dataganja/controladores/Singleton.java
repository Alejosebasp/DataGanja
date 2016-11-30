package com.alejosebasp.dataganja.controladores;

/**
 * Created by alejandrosebastian on 29/11/2016.
 */

        import android.content.Context;
        import android.graphics.Bitmap;
        import android.util.LruCache;

        import com.android.volley.Request;
        import com.android.volley.RequestQueue;
        import com.android.volley.toolbox.ImageLoader;
        import com.android.volley.toolbox.Volley;



public final class Singleton {

    // Atributos
    private static Singleton singleton;
    private ImageLoader imageLoader;
    private RequestQueue requestQueue;
    private static Context context;

    private Singleton(Context context) {
        Singleton.context = context;
        requestQueue = getRequestQueue();

        imageLoader = new ImageLoader(requestQueue,
                new ImageLoader.ImageCache() {
                    private final LruCache<String, Bitmap> cache = new LruCache<>(20);

                    @Override
                    public Bitmap getBitmap(String url) {
                        return cache.get(url);
                    }

                    @Override
                    public void putBitmap(String url, Bitmap bitmap) {
                        cache.put(url, bitmap);
                    }
                });
    }

    public static synchronized Singleton getInstance(Context context) {
        if (singleton == null) {
            singleton = new Singleton(context);
        }
        return singleton;
    }

    public RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(context.getApplicationContext());
        }
        return requestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }

    public ImageLoader getImageLoader() {
        return imageLoader;
    }

}

