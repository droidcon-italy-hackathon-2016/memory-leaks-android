package com.elpassion.memoryleaks.ui.elder.list

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.elpassion.memoryleaks.R
import com.elpassion.memoryleaks.common.android.loadWithGlide
import com.elpassion.memoryleaks.model.Elder

class EldersListAdapter(val eldersList: List<Elder>,
                        val onElderClickListener: (String) -> Unit) : RecyclerView.Adapter<EldersListAdapter.ElderHolder>() {

    override fun getItemCount() = eldersList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ElderHolder(LayoutInflater.from(parent.context).inflate(R.layout.elder_item, parent, false))

    override fun onBindViewHolder(holder: ElderHolder, position: Int) {
        val photo = holder.itemView.findViewById(R.id.elder_photo) as ImageView
        photo.loadWithGlide(eldersList[position].photoUrl)
        holder.itemView.findViewById(R.id.send_ping)!!.setOnClickListener {
            onElderClickListener("grandma-id")
        }
    }

    class ElderHolder(itemView: View?) : RecyclerView.ViewHolder(itemView)
}
