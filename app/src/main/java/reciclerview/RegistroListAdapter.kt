package reciclerview

import android.content.Context
import android.provider.ContactsContract
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tillduo.frequencia.R
import kotlinx.android.synthetic.main.registro_item.view.*

class RegistroListAdapter(private val registros: List<Registro>,
                          private val context: Context) : RecyclerView.Adapter<RegistroListAdapter.ViewHolder>() {

    override fun onBindViewHolder(p0: ViewHolder, position: Int) {
        val registro = registros[position]
        p0?.let {
            it.bindView(registro)
        }
    }

    override fun onCreateViewHolder(p0: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.registro_item, p0,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return registros.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(registro: Registro) {
            val titulo = itemView.titulo
            val descricao = itemView.descricao

            titulo.text = registro.titulo
            descricao.text = registro.descricao
        }
    }

}