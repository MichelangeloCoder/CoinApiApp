package com.example.coinapiapp.presentationlayer.coinlist

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.coinapiapp.R
import com.example.coinapiapp.domain.model.Coin
import com.example.coinapiapp.presentationlayer.coin.CoinActivity
import com.squareup.picasso.Picasso

class CoinAdapter(private val context: Context, var coinList : ArrayList<Coin>) : RecyclerView.Adapter<CoinAdapter.CoinViewHolder>(), Filterable {

    lateinit var filterList : ArrayList<Coin>
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinAdapter.CoinViewHolder {
        val coinView = LayoutInflater.from(parent.context).inflate(R.layout.coin_recycler_view,parent,false)
        return CoinViewHolder(coinView)
    }

    override fun onBindViewHolder(holder: CoinAdapter.CoinViewHolder, position: Int) {
        val coin = coinList[position]
        holder.coinName.text = coin.name
        holder.coinLayout.setOnClickListener {
            val intent = Intent(context, CoinActivity::class.java)
            intent.putExtra("id",coin.id)
            context.startActivity(intent)

        }
        Picasso.get().load(coin.image).into(holder.coinImage)
    }

    override fun getItemCount(): Int {
        return coinList.size
    }

    fun setData(list : ArrayList<Coin>){
        this.filterList = list
        this.coinList = list
        notifyDataSetChanged()
    }

    inner class CoinViewHolder (view : View) : RecyclerView.ViewHolder(view){

        val coinLayout : LinearLayout = view.findViewById(R.id.coinLinearLayout)
        val coinImage : ImageView = view.findViewById(R.id.imgCoinImage)
        val coinName: TextView = view.findViewById(R.id.txtCoinName)
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val string = constraint?.toString() ?: ""
                if (string.isNotEmpty()){
                    var arrayList = arrayListOf<Coin>()
                    filterList.filter {
                        it.name.lowercase().contains(string.lowercase())
                    }.forEach{
                        arrayList.add(it)
                    }
                    filterList.clear()
                    filterList.addAll(arrayList)
                } else {
                    filterList = coinList
                }
                return FilterResults().apply {
                    this.values = filterList
                }
            }


            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                if (results?.values == null){
                    ArrayList<Coin>()
                } else {
                    setData(filterList)
                }
            }

        }
    }


}