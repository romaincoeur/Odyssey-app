package fr.wildcodeschool.odyssey;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.LinkedHashMap;

/**
 * Created by romain on 11/08/16.
 */
public class ListQuestAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private LinkedHashMap <Long, Quest> listQuest;

    private static class ViewHolder {
        private ImageView image;
        private TextView text;
    }

    private static ListQuestAdapter instance;

    public static ListQuestAdapter getInstance(Context context) {
        if (instance == null)
            instance = new ListQuestAdapter(context);
        return instance;
    }

    private ListQuestAdapter(Context context) {
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.listQuest = new LinkedHashMap<>();
    }

    @Override
    public int getCount() {
        return listQuest.size();
    }

    @Override
    public Object getItem(int i) {
        return (Quest) listQuest.values().toArray()[i];
    }

    @Override
    public long getItemId(int i) {
        Quest q = (Quest) getItem(i);
        return q.getId();
    }

    public Quest getQuestById(long id) {                                                                    // Retourne un objet de type Monster en fonction de son Id
        return listQuest.get(id);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {             // Cette métode retourne l'objet View à afficher pour la ligne à la position demandée
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.quest_row, null);					// création de la vue en fonction du fichier XML ligne_liste.xml si elle n'existe pas (le paramètre convertView est null).
            holder = new ViewHolder();
            holder.text 		= (TextView)convertView.findViewById(R.id.title);		    // On créé et sauvegarde le composant TextView dans la classe Holder
            holder.image 	= (ImageView) convertView.findViewById(R.id.imgType);       // Idem pour ImageView
            convertView.setTag(holder);													// La classe holder est positionnée dans la zone Tag du composant convertView pour la prochaine fois que l'on doit réafficher cette ligne
        }
        else
            holder = (ViewHolder)convertView.getTag();									// La vue existe déjà, on récupère le mappage des composants (holder) dans le Tag

        Quest q = (Quest) getItem(position);									    // On récupère l'étudiant correspondant à la position passée en paramètre
        holder.text.setText(q.getTitle()/*.toUpperCase()*/);								// on positionne ou raffraichit les informations de la vue selon le cas

        int imgResourceId;
        switch ((String)q.getParcours()) {                                                   // initialisation de la variable imgResourceId en fonction de la valeur du type de monstre
            case "php" : imgResourceId = R.drawable.php;break;
            case "js" : imgResourceId = R.drawable.javascript;break;
            case "sf" : imgResourceId = R.drawable.symfony;break;
            default : imgResourceId = -1;
        }

        if (imgResourceId != -1)
            holder.image.setImageBitmap(BitmapFactory.decodeResource(inflater.getContext().getResources(), imgResourceId));

        return convertView;
    }

    public void addQuest(Quest q) {                                           // Ajoute un objet Monstre à la liste
        listQuest.put(q.getId(), q);
    }
}
