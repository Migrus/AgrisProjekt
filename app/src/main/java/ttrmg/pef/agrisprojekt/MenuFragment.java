package ttrmg.pef.agrisprojekt;

import android.annotation.TargetApi;
import android.app.ListFragment;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)



public class MenuFragment extends ListFragment {
    int velikost = 25;
    String[] Burzy = new String[] {
            "Denní ceny masa v ČR - SZIF ČR",
            "Plodinová burza Brno - parita FCA (parita A) - ČR",
            "Plodinová burza Brno - parita DDP (parita B) - ČR",
            "Týdenní farmářské ceny v ČR - ČSÚ",
            "Spotřebitelské ceny v ČR - ČSÚ",
            "Kurzy měn - ČNB, ECB",
            "Chicago Board of Trade",
            "Chicago Mercantile Exchange",
            "Obchodní burza Hradec Králové",
            "Průměrné ceny pohonných hmot - ČSÚ"
    };
    String[][] ceny = new String[velikost][4];



    public String[][] naplnPole(String[][] cena){
        for (int i = 0; i< velikost;i++){
            for (int j = 0; j<= 3;j++) {
                switch (j){
                    case 0:
                        cena[i][j] = "(" + i + ") 31.10.2014";
                        break;
                    case 1:
                        cena[i][j] = "(" + i + ") Vepřová plec bez kosti";
                        break;
                    case 2:
                        cena[i][j] = "(" + i + ") 77,16";
                        break;
                    case 3:
                        cena[i][j] = "(" + i + ") Kč/kg";
                        break;
                }
            }
        }

        return cena;
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.list_fragment, container, false);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, Burzy);
        setListAdapter(adapter);
        naplnPole(ceny);

        return view;

    }
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {

        TextFragment txt = (TextFragment)getFragmentManager().findFragmentById(R.id.fragment2);
        txt.change(Burzy[position],"Version : "+ceny[position][1]);
        getListView().setSelector(android.R.color.holo_blue_dark);
    }
}