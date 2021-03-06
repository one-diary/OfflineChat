package com.pk.inchat;

import android.content.Context;
import android.graphics.Color;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import 	androidx.core.app.ActivityCompat;
import 	androidx.core.content.ContextCompat;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.Size;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class ChatMessageAdapter extends ArrayAdapter<MessageInstance> {
    private Context ctx;

    ChatMessageAdapter(Context ctx, int resource){
        super(ctx, resource);
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.chat_message, null, false);
        MessageInstance msg = (MessageInstance) getItem(position);

        TextView messageView = (TextView) view.findViewById(R.id.singleMessage);
        ImageView imageView = (ImageView) view.findViewById(R.id.chat_image);
        LinearLayout layout = (LinearLayout) view.findViewById(R.id.chat_linear_layout);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.gravity = (msg.send ? Gravity.END : Gravity.START);
        layout.setLayoutParams(params);


        if(msg.message != null) {

            messageView.setText(msg.message);
          //  messageView.setBackgroundResource((msg.send) ? R.drawable.ic_chat_24 : R.drawable.ic_chat_bubble_outline_24);
            messageView.setTextSize(14);
            //messageView.setPadding(5,5,5,5);
            LinearLayout.LayoutParams params_message = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params_message.width = 0;
            params_message.height = 0;
            imageView.setLayoutParams(params_message);

        } else if(msg.imageBitmap != null) {
            imageView.setImageBitmap(msg.imageBitmap);
            messageView.setBackgroundResource(0);
          //  imageView.setBackgroundResource((msg.send) ? R.drawable.ic_chat_24 : R.drawable.ic_chat_bubble_outline_24);
        }
        return view;
    }
}
