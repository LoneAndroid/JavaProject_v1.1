package topsecretinformation.javaproject_v11;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by User on 3/22/2017.
 */

public class MessageAdapter extends ArrayAdapter<Message> {

    public MessageAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Message> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        Message message = getItem(position); // работаем с этим сообщением

        // создаём вьюшку по макету в зависимости от отправителя
        View view;
        if (message.sender == Message.SENDER_BOT) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.bot, parent, false);
        } else {
            view = LayoutInflater.from(getContext()).inflate(R.layout.user, parent, false);
        }

        // заполняем вьюшку
//        TextView messageTextView = (TextView) view.findViewById(R.id.WWWWWWWWWWWWWWWWWWWWW);
//        messageTextView.setText(message.text);

        // возращаем созданный элементик
        return view;
    }

}
