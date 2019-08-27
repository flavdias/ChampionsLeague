package com.example.flavi.championsleague

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.flavi.domain.Pais

class PaisAdapter internal constructor(context: Context): RecyclerView.Adapter<PaisAdapter.PaisViewHolder>() {

    private val inflater = LayoutInflater.from(context)
    private var paises = emptyList<Pais>()

    inner class PaisViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val paisItemView : TextView = itemView.findViewById(R.id.textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaisViewHolder {
        val itemView = inflater.inflate(R.layout.recyclerview_item, parent, false)
        return PaisViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PaisViewHolder, position: Int) {
        val atual = paises[position]
        holder.paisItemView.text = atual.nome
    }

    internal fun setPaises(paises: List<Pais>) {
        this.paises = paises
        notifyDataSetChanged()
    }

    override fun getItemCount() = paises.size
}