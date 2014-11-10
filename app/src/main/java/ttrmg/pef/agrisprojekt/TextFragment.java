package ttrmg.pef.agrisprojekt;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.app.ListActivity;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TextView;
@TargetApi(Build.VERSION_CODES.HONEYCOMB)



public class TextFragment extends Fragment {
    TextView datumm,komoditaa,menaa,jednotkyy;
    ListView listDatum,listKomodita,listMena,listJednotky;
    GridView grid;

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.text_fragment, container, false);
        grid = (GridView) view.findViewById(R.id.grid);
        return view;
    }
    public void change(String[]ceny){

        ArrayAdapter<String> adapterDatum = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, ceny);
        grid.setAdapter(adapterDatum);
    }

}