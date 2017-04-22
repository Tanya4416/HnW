package com.example.shujareshi.hnm;
        import android.content.Intent;
        import android.net.Uri;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.support.v7.widget.CardView;
        import android.view.View;
        import android.widget.ImageButton;

public class yoga extends AppCompatActivity implements View.OnClickListener{

    CardView Cv1,Cv2,Cv3,Cv4,Cv5,Cv6,Cv7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yoga);



        Cv2= (CardView)findViewById(R.id.card_view2);
        Cv3= (CardView)findViewById(R.id.card_view3);
        Cv4= (CardView)findViewById(R.id.card_view4);
        Cv5= (CardView)findViewById(R.id.card_view5);
        Cv6= (CardView)findViewById(R.id.card_view6);
        Cv7= (CardView)findViewById(R.id.card_view7);


        Cv2.setOnClickListener(this);
        Cv3.setOnClickListener(this);
        Cv4.setOnClickListener(this);
        Cv5.setOnClickListener(this);
        Cv6.setOnClickListener(this);
        Cv7.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        if(view==Cv2)
        {
            String url = "https://www.youtube.com/watch?v=XHXbNpKPCsg>";

            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
            //startActivity(new Intent(this , hackathon.class));

        }
        else if(view==Cv3)
        {
            String url = "https://www.youtube.com/watch?v=Mr_zrJrv9cc>";

            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
            // startActivity(new Intent(this , poster.class));

        }
        else if(view==Cv4)
        {
            String url = "https://www.youtube.com/watch?v=LFvu2arz2UA>";

            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
            // startActivity(new Intent(this , execute.class));

        }
        else if(view==Cv5)
        {
            String url = "https://www.youtube.com/watch?v=9QyXbfLIj7g>";

            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
            //startActivity(new Intent(this , robotics.class));

        }
        else if(view==Cv6)
        {
            String url = "https://www.youtube.com/watch?v=XHXbNpKPCsg>";

            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
            //startActivity(new Intent(this , scavenger.class));

        }
        else if(view==Cv7)
        {
            String url = "https://www.youtube.com/watch?v=9QyXbfLIj7g>";

            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
            // startActivity(new Intent(this , circuit.class));

        }

    }
}
