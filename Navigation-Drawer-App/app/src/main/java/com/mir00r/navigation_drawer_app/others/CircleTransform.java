package com.mir00r.navigation_drawer_app.others;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;

/**
 * Created by Mir00r on 8/9/2017.
 */

public class CircleTransform extends BitmapTransformation {

    public CircleTransform(Context context) {
        super(context);
    }

    public CircleTransform(BitmapPool bitmapPool) {
        super(bitmapPool);
    }

    @Override
    protected Bitmap transform(BitmapPool pool, Bitmap toTransform, int outWidth, int outHeight) {
        return null;
    }

    private static Bitmap circleCrop(BitmapPool pool, Bitmap bitmapOrSource) {
        int size, height, width, x, y;

        if (bitmapOrSource == null) return null;

        height = bitmapOrSource.getHeight();
        width = bitmapOrSource.getWidth();
        size = Math.min(height, width);

        x = (height - size) / 2;
        y = (width - size) / 2;

        //Bitmap squared = Bitmap.createBitmap(bitmapOrSource, x, y, width, height);
        Bitmap squared = Bitmap.createBitmap(bitmapOrSource, x, y, size, size);
        Bitmap result = pool.get(size, size, Bitmap.Config.ARGB_8888);
        if (result == null) {
            result = pool.get(size, size, Bitmap.Config.ARGB_8888);
        }

        Canvas canvas = new Canvas(result);
        Paint paint = new Paint();
        paint.setShader(new BitmapShader(squared, BitmapShader.TileMode.CLAMP, BitmapShader.TileMode.CLAMP));
        paint.setAntiAlias(true);
        float r = size / 2f;
        canvas.drawCircle(r, r, r, paint);
        return result;
    }

    @Override
    public String getId() {
        return getClass().getName();
    }
}
