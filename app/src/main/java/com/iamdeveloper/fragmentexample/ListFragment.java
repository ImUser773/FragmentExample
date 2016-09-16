package com.iamdeveloper.fragmentexample;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {
    private ListView listView;
    private ArrayAdapter<String> adapter;
    private String screen;
    private String[] number = {"1","2","3","4","5"};



    public ListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        screen = getResources().getString(R.string.screen);
        Toast.makeText(view.getContext(),screen,Toast.LENGTH_SHORT).show();



        listView = (ListView) view.findViewById(R.id.list_view);
        adapter = new ArrayAdapter<String>(view.getContext(),android.R.layout.simple_list_item_1,android.R.id.text1,number);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                ContentFragment contentFragment = ContentFragment.newInstance(number[i]);
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                if(screen.equals("9-inch-tablet")){
                    transaction.replace(R.id.fragment_content_2,contentFragment).commit();
                }else if(screen.equals("phone")){
                    transaction.add(R.id.fragment_content,contentFragment).addToBackStack(null).commit();
                }

            }
        });
    }
}
