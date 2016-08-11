package fr.wildcodeschool.odyssey;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by romain on 11/08/16.
 */
public class FicheActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fiche_quest);                                   // Associe le fichier XML à l'activité, c'est dans ce fichier qu'on ira chercher les correspondances avec les composants.

        long monsterId = getIntent().getLongExtra("quest_id", -1);  // récupère la valeur de l'id du monstre dans l'Intent passé en paramètre s'il y en a un.

        if (monsterId != -1) {
            ListQuestAdapter adapter = ListQuestAdapter.getInstance(this);      // On utilise une instance de ListMonsterAdapter pour accéder aux données
            Quest q = adapter.getQuestById(monsterId);                          // renvoi un objet Monstre grâce à son id

            TextView txtTitle = (TextView) findViewById(R.id.txtTitleQuest);           // On associe des objets à chaque élément du fichier XML devant être affecté
            TextView txtAbstract = (TextView) findViewById(R.id.txtAbstractQuest);
            TextView txtObjectives = (TextView) findViewById(R.id.txtObjectivesQuest);
            ImageView imgParcours = (ImageView) findViewById(R.id.imgParcours);

            txtTitle.setText(q.getTitle());                                             // on affecte les bonnes valeurs aux objets
            txtAbstract.setText(q.get_abstract());
            txtObjectives.setText(String.valueOf(q.getObjectives()));

            imgParcours.setImageResource(R.drawable.angular);
        }
    }
}