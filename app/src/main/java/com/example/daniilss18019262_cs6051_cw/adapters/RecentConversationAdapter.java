package com.example.daniilss18019262_cs6051_cw.adapters;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.daniilss18019262_cs6051_cw.databinding.ItemContainerRecentConversionBinding;
import com.example.daniilss18019262_cs6051_cw.listeners.ConversionListener;
import com.example.daniilss18019262_cs6051_cw.models.ChatMessages;
import com.example.daniilss18019262_cs6051_cw.models.User;

import java.util.List;

public class RecentConversationAdapter extends RecyclerView.Adapter<RecentConversationAdapter.ConversionViewHolder>{

    private final List<ChatMessages> chatMessages;
    private  final ConversionListener conversionListener;

    public RecentConversationAdapter(List<ChatMessages> chatMessages, ConversionListener conversionListener) {
        this.chatMessages = chatMessages;
        this.conversionListener = conversionListener;
    }

    @NonNull
    @Override
    public ConversionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ConversionViewHolder(
                ItemContainerRecentConversionBinding.inflate(
                        LayoutInflater.from(parent.getContext()),
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull ConversionViewHolder holder, int position) {
        holder.setData(chatMessages.get(position));


    }

    @Override
    public int getItemCount() {
        return chatMessages.size();
    }

    class ConversionViewHolder extends RecyclerView.ViewHolder {

        ItemContainerRecentConversionBinding binding;

        ConversionViewHolder(ItemContainerRecentConversionBinding itemContainerRecentConversionBinding) {
            super(itemContainerRecentConversionBinding.getRoot());
            binding = itemContainerRecentConversionBinding;
        }

        void setData(ChatMessages chatMessages) {
            binding.imageProfile.setImageBitmap(getConversionImage(chatMessages.conversionImage));
            binding.textName.setText(chatMessages.conversionName);
            binding.textRecentMessage.setText(chatMessages.message);
            binding.getRoot().setOnClickListener(v -> {
                User user = new User();
                user.id = chatMessages.conversionId;
                user.name = chatMessages.conversionName;
                user.image = chatMessages.conversionImage;
                conversionListener.onConversionClicked(user);
            });
        }
    }

    private Bitmap getConversionImage(String encodedImage) {
        byte[] bytes = Base64.decode(encodedImage, Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
    }

}
