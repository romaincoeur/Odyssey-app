package fr.wildcodeschool.odyssey;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class MainActivity extends ListActivity {

    private ListQuestAdapter adapter;
    private Cursor cursor;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = ListQuestAdapter.getInstance(this);

        adapter.addQuest(new Quest(1, "Dans la peau d'un cornac", "Un cornac (dérivé du mot indien cornaca) ou mahout, est à la fois le maître, le guide et le soigneur de l'éléphant.", "Décrire le rôle de PHP dans une application client/serveur", "Crée un fichier du type index.php", "Crée un fichier du type index.php", "Crée un fichier du type index.php", "php"));
        adapter.addQuest(new Quest(2, "Installation de Phpstorm", "Cette quête te permettra de prendre en main l'IDE choisi par la Wild Code School pour développer les projets PHP. Au-delà de sa grande utilisation en entreprise cet outil est intéressant car il s'installe sur de nombreux OS et propose un panel d'extensions conséquent.", "A la fin de cette quête tu auras installé Phpstorm sur ta machine et tu sauras utiliser les fonctionnalités principales.", "Crée ton premier projet avec Phpstorm", "Le challenge est de créer un projet PHP avec Phpstorm", "La page affiche la liste et la moyenne", "sf"));

        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        // L'utilisateur a cliqué sur une ligne correspondant à une quête.
        Intent ficheIntent = new Intent(this,FicheActivity.class);	// Construit l'Intent pour passer à l'activité Fiche
        ficheIntent.putExtra("quest_id", id);		// Ajoute le paramètre Id de l'étudiant à l'Intent
        startActivity(ficheIntent);									// démarre l'activité Fiche
    }
}
