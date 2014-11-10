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

    public String[] ceny = new String[4*velikost];


    public void naplnPole(){
        for (int i=0;i<velikost;i++ ) {
                switch (i % 4){
                    case 0:
                        ceny[i] = "31.10.2014";
                        break;
                    case 1:
                        ceny[i] = "Vepřová plec bez kosti";
                        break;
                    case 2:
                        ceny[i] = "77,16";
                        break;
                    case 3:
                        ceny[i] = "Kč/kg";
                        break;
                }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.list_fragment, container, false);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, Burzy);
        setListAdapter(adapter);
        naplnPole();

        return view;

    }
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {

        TextFragment txt = (TextFragment)getFragmentManager().findFragmentById(R.id.fragment2);
        txt.change(ceny);
        getListView().setSelector(android.R.color.holo_blue_dark);
    }
}