package br.com.udemy.todo.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.widget.ImageView;

public class ImagemUtils {

    public static void setImagem(ImageView view, String caminho){
        setImagem(view, caminho, 512, 512);


    }

    public static void setImagem(ImageView view, String caminho, int largura, int altura) {
        if(caminho != null & caminho != ""){
            Bitmap bitmap = BitmapFactory.decodeFile(caminho);
            if(bitmap != null){
                Bitmap scaledBitmap = Bitmap.createScaledBitmap(bitmap, largura, altura, true);
                view.setImageBitmap(scaledBitmap);
                view.setBackgroundColor(Color.TRANSPARENT);
                view.setTag(caminho);
                view.setScaleType(ImageView.ScaleType.CENTER_CROP); //a partir do centro corta o que nao couber na tela
            }
        }
    }
}
