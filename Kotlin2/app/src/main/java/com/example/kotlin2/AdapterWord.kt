package com.example.kotlin2
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin2.data.Word

class AdapterWord(private val words: MutableList<Word>, _onItemClicked: OnItemClicked) :
    RecyclerView.Adapter<AdapterWord.ViewHolderWord>() {
    private val onItemClicked=_onItemClicked

    class ViewHolderWord(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textViewWord: TextView = itemView.findViewById(R.id.textViewWord)
        private val imageViewRemove: ImageView = itemView.findViewById(R.id.imageViewRemove)
        private val imageViewEdit: ImageView = itemView.findViewById(R.id.imageViewEdit)

        fun bind(word: Word, onItemClicked: OnItemClicked) {
            textViewWord.text = word.newWord
            imageViewEdit.setOnClickListener {
                onItemClicked.onItemClickedEdit(adapterPosition) }
            imageViewRemove.setOnClickListener { onItemClicked.onItemClickedRemove(adapterPosition) }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderWord {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler_view, parent, false)
        return ViewHolderWord(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolderWord, position: Int) {
        val word = words[position]
        holder.bind(word, onItemClicked)
    }

    override fun getItemCount() = words.size
}

