package com.example.primeraapp;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.primeraapp.DB.ContactsDBHelper;
import com.example.primeraapp.MODEL.Contact;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FormFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FormFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ContactsDBHelper dbHelper;
    private SQLiteDatabase ondb;


    public FormFragment() {
        // Required empty public constructor
    }
    public FormFragment(ContactsDBHelper dbHelper, SQLiteDatabase ondb) {
       this.dbHelper=dbHelper;
       this.ondb=ondb;
    }



    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FormFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FormFragment newInstance(String param1, String param2) {
        FormFragment fragment = new FormFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View view = inflater.inflate(R.layout.fragment_form, container, false);
         EditText IdNombreEquipo = view.findViewById(R.id.IdNombreEquipo);
         EditText IdFecha = view.findViewById(R.id.IdFecha);
         EditText idComentario = view.findViewById(R.id.idComentario);
         dbHelper = new ContactsDBHelper(getContext());
         ondb=dbHelper.getWritableDatabase();
         Button idButtonEnviar = view.findViewById(R.id.idButtonEnviar);
         idButtonEnviar.setOnClickListener(e->{
             Contact contact = new Contact(IdNombreEquipo.getText().toString(),IdFecha.getText().toString(),idComentario.getText().toString());
             dbHelper.insertContact(ondb,contact);
         });
         return view;
    }
}
