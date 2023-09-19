package com.example.peddigitallitesecundaria.ui.gallery;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.peddigitallitesecundaria.R;
import com.example.peddigitallitesecundaria.databinding.FragmentGalleryBinding;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;
import android.widget.ImageView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class GalleryFragment extends Fragment {

    private FragmentGalleryBinding binding;
    GetXMLTask task;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.fragment_gallery, container, false);

        ImageView sexto = (ImageView) rootView.findViewById(R.id.imageView3);
        sexto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(verificar("VideosSexto") == 0){
                    if(isInternetAvailable()){
                        loadJSON("PEDLITESECUNDARIA/SextoGrado/asignaturas/VidTemas.json", "PEDLITESECUNDARIA/SextoGrado/modulos/VidTemas.json", "VideosSexto", "Sexto", 0);
                    }else{
                        mensaje_alerta(GalleryFragment.this.getActivity(), 2);
                    }
                }else{
                    mensaje_alerta(GalleryFragment.this.getActivity(), 1);
                }
            }
        });

        ImageView septimo = (ImageView) rootView.findViewById(R.id.imageView4);
        septimo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(verificar("VideosSeptimo") == 0){
                    if(isInternetAvailable()){
                        loadJSON("PEDLITESECUNDARIA/SeptimoGrado/asignaturas/VidTemas.json", "PEDLITESECUNDARIA/SeptimoGrado/modulos/VidTemas.json",  "VideosSeptimo", "Septimo", 0);
                    }else{
                        mensaje_alerta(GalleryFragment.this.getActivity(), 2);
                    }
                }else{
                    mensaje_alerta(GalleryFragment.this.getActivity(), 1);
                }
            }
        });

        ImageView octavo = (ImageView) rootView.findViewById(R.id.imageView5);
        octavo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(verificar("VideosOctavo") == 0){
                    if(isInternetAvailable()){
                        loadJSON("PEDLITESECUNDARIA/OctavoGrado/asignaturas/VidTemas.json", "PEDLITESECUNDARIA/OctavoGrado/modulos/VidTemas.json", "VideosOctavo", "Octavo", 0);
                    }else{
                        mensaje_alerta(GalleryFragment.this.getActivity(), 2);
                    }
                }else{
                    mensaje_alerta(GalleryFragment.this.getActivity(), 1);
                }
            }
        });

        ImageView noveno = (ImageView) rootView.findViewById(R.id.imageView7);
        noveno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(verificar("VideosNoveno") == 0){
                    if(isInternetAvailable()){
                        loadJSON("PEDLITESECUNDARIA/NovenoGrado/asignaturas/VidTemas.json","PEDLITESECUNDARIA/NovenoGrado/modulos/VidTemas.json", "VideosNoveno","Noveno", 0);
                    }else{
                        mensaje_alerta(GalleryFragment.this.getActivity(), 2);
                    }
                }else{
                    mensaje_alerta(GalleryFragment.this.getActivity(), 1);
                }
            }
        });

        ImageView decimo = (ImageView) rootView.findViewById(R.id.imageView8);
        decimo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(verificar("VideosDecimo") == 0){
                    if(isInternetAvailable()){
                        loadJSON("PEDLITESECUNDARIA/DecimoGrado/asignaturas/VidTemas.json","PEDLITESECUNDARIA/DecimoGrado/modulos/VidTemas.json",  "VideosDecimo", "Decimo", 0);
                    }else{
                        mensaje_alerta(GalleryFragment.this.getActivity(), 2);
                    }
                }else{
                    mensaje_alerta(GalleryFragment.this.getActivity(), 1);
                }
            }
        });

        ImageView undecimo = (ImageView) rootView.findViewById(R.id.imageView2);
        undecimo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(verificar("VideosUndecimo") == 0){
                    if(isInternetAvailable()){
                        loadJSON("PEDLITESECUNDARIA/UndecimoGrado/asignaturas/VidTemas.json","PEDLITESECUNDARIA/UndecimoGrado/modulos/VidTemas.json",  "VideosUndecimo", "Undecimo", 0);
                    }else{
                        mensaje_alerta(GalleryFragment.this.getActivity(), 2);
                    }
                }else{
                    mensaje_alerta(GalleryFragment.this.getActivity(), 1);
                }
            }
        });

        ImageView descargar_todo = (ImageView) rootView.findViewById(R.id.imageView6);
        descargar_todo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] grados = {"SextoGrado", "SeptimoGrado", "OctavoGrado", "NovenoGrado", "DecimoGrado", "UndecimoGrado"};
                String[] carpetas = {"VideosSexto", "VideosSeptimo", "VideosOctavo", "VideosNoveno", "VideosDecimo", "VideosUndecimo"};
                String[] nombreGrados = {"Sexto", "Septimo", "Octavo", "Noveno", "Decimo", "Undecimo"};

                for (int i=0; i < grados.length; i++) {
                    if (verificar(carpetas[i]) == 0) {
                        if (isInternetAvailable()) {
                            loadJSON("PEDLITESECUNDARIA/"+grados[i]+"/asignaturas/VidTemas.json", "PEDLITESECUNDARIA/"+grados[i]+"/modulos/VidTemas.json", carpetas[i], nombreGrados[i], 1);
                        } else {
                            mensaje_alerta(GalleryFragment.this.getActivity(), 2);
                        }
                    } else {
                        mensaje_alerta(GalleryFragment.this.getActivity(), 1);
                    }
                }
            }
        });

        verificar_descargados(rootView);

        return rootView;
    }

    public int verificar(String carpeta){
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM),carpeta);
        if(file.exists()){
           return 1;
        }else{
           return 0;
        }
    }

    public boolean isInternetAvailable() {
        try {
            Process p = java.lang.Runtime.getRuntime().exec("ping -c 1 www.google.es");
            int val  = p.waitFor();
            boolean reachable = (val == 0);
            return reachable;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void mensaje_alerta(Context context, Integer tipo){

        String mensaje = "";

        if(tipo == 1){
            mensaje = "Los recursos de este grado, ya han sido descargados.";
        }else{
            mensaje = "Debe estar conectado a una red wi-fi, o datos móviles para descargar los recursos.";
        }

        AlertDialog.Builder builder1 = new AlertDialog.Builder(context);
        builder1.setMessage(mensaje);
        builder1.setTitle("  Atención!");
        if(tipo == 1){
            builder1.setIcon(R.drawable.success);
        }else{
            builder1.setIcon(R.drawable.network);
        }

        builder1.setPositiveButton(
            "Ok",
            new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });

        AlertDialog alert11 = builder1.create();
        alert11.show();
    }

    public void verificar_descargados(View vista){
        ImageView img_1= (ImageView) vista.findViewById(R.id.imageView3);
        ImageView img_2= (ImageView) vista.findViewById(R.id.imageView4);
        ImageView img_3= (ImageView) vista.findViewById(R.id.imageView5);
        ImageView img_4= (ImageView) vista.findViewById(R.id.imageView7);
        ImageView img_5= (ImageView) vista.findViewById(R.id.imageView8);
        ImageView img_6= (ImageView) vista.findViewById(R.id.imageView2);

        File file_1 = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM),"VideosSexto");
        if(file_1.exists()){
            img_1.setImageResource(R.drawable.grado6_2);
        }else{
            img_1.setImageResource(R.drawable.grado6);
        }

        File file_2 = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM),"VideosSeptimo");
        if(file_2.exists()){
            img_2.setImageResource(R.drawable.grado7_2);
        }else{
            img_2.setImageResource(R.drawable.grado7);
        }

        File file_3 = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM),"VideosOctavo");
        if(file_3.exists()){
            img_3.setImageResource(R.drawable.grado8_2);
        }else{
            img_3.setImageResource(R.drawable.grado8);
        }

        File file_4 = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM),"VideosNoveno");
        if(file_4.exists()){
            img_4.setImageResource(R.drawable.grado9_2);
        }else{
            img_4.setImageResource(R.drawable.grado9);
        }
        File file_5 = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM),"VideosDecimo");
        if(file_5.exists()){
            img_5.setImageResource(R.drawable.grado10_2);
        }else{
            img_5.setImageResource(R.drawable.grado10);
        }
        File file_6 = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM),"VideosUndecimo");
        if(file_6.exists()){
            img_6.setImageResource(R.drawable.grado11_2);
        }else{
            img_6.setImageResource(R.drawable.grado11);
        }
    }

    public void loadJSON(String nombreArchivo, String nombreArchivo2, String carpeta, String grado, int tipoDescarga){
        try {
            JSONArray m_jArray = new JSONArray(loadJSONFromAsset(nombreArchivo));
            JSONArray m_jArray2 = new JSONArray(loadJSONFromAsset(nombreArchivo2));

            // Crear un nuevo JSONArray para concatenar los elementos
            JSONArray concatenatedArray = new JSONArray();

            // Agregar elementos del primer JSONArray
            for (int i = 0; i < m_jArray.length(); i++) {
                JSONObject jo_inside = m_jArray.getJSONObject(i);
                concatenatedArray.put(jo_inside);
            }

            // Agregar elementos del segundo JSONArray
            for (int i = 0; i < m_jArray2.length(); i++) {
                JSONObject jo_inside = m_jArray2.getJSONObject(i);
                concatenatedArray.put(jo_inside);
            }

            // Ahora, `concatenatedArray` contiene la concatenación de ambos arrays
            String rutas[] = new String[concatenatedArray.length()];

            for (int i = 0; i < concatenatedArray.length(); i++) {
                JSONObject jo_inside = concatenatedArray.getJSONObject(i);
                String url = jo_inside.getString("nomvid");
                rutas[i] = url;
                Log.d("ruta: ", rutas[i]);
            }

            task = new GetXMLTask( GalleryFragment.this.getActivity(), carpeta, grado, tipoDescarga);
            task.execute(rutas);

        } catch (JSONException e) {
            Log.i("error_video", e.getMessage());
        }
    }

    public String loadJSONFromAsset(String nombreArchivo) {
        String json = null;
        try {
            InputStream is = GalleryFragment.this.getContext().getAssets().open(nombreArchivo);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private class GetXMLTask extends AsyncTask<String, Integer, Void> {
        ProgressDialog progressDialog;
        private Activity context;
        String carpet;
        int noOfURLs;
        int noErrores;
        List<Integer> rowItems;
        String grado;
        int tipoDescarga;

        public GetXMLTask(Activity context, String pCarpet, String pGrado, int ptipoDescarga) {
            this.carpet = pCarpet;
            this.context = context;
            this.grado = pGrado;
            this.tipoDescarga = ptipoDescarga;
        }

        @Override
        protected void onPreExecute() {
            progressDialog = new ProgressDialog(context);

            progressDialog.setMessage("Espere un momento....");
            if(this.tipoDescarga == 0){
                progressDialog.setTitle("Descargando videos de ("+this.grado+") grado. ");
                progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            }else{
                progressDialog.setTitle("Descargando videos de todos los grados");
            }
            progressDialog.setIcon(R.drawable.ic_arrow_drop_down_circle_24dp);
            progressDialog.setIndeterminate(false);
            progressDialog.setMax(100);
            progressDialog.setCancelable(true);
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {

                @Override
                public void onCancel(DialogInterface dialog) {
                    // TODO Auto-generated method stub
                    Log.d("GettingCancelled","onCancel(DialogInterface dialog)");
                    task.cancel(true);
                    GalleryFragment.this.getActivity().finish();
                }
            });
            progressDialog.show();
        }


        @Override
        protected Void doInBackground(String... urls) {
            noOfURLs = urls.length;
            rowItems = new ArrayList<Integer>();
            noErrores = 0;

            for (String url : urls) {
                rowItems.add(0);
                downloadImage(url);
                if (isCancelled()==true){
                    Log.d("GettingCancelled","isCancelled");
                    break;
                }
            }

            verificar_descargados(context);

            return null;
        }

        private void downloadImage(String urlString) {
            publishProgress((int) (((rowItems.size()+1) * 100) / noOfURLs));
            File myFolder = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM), carpet);
            myFolder.mkdir();

            String fileURL = "https://csi-ingenieria.com/"+carpet+"/"+urlString;

            Log.d("Descargando: ", fileURL);
            try {
                URL url = new URL(fileURL);
                HttpURLConnection c = (HttpURLConnection) url.openConnection();
                c.setRequestMethod("GET");
                c.setDoOutput(true);
                c.connect();

                File outputFile = new File(myFolder, urlString);
                if (outputFile.exists()) {
                    Log.d("archivo", "existe");
                }

                FileOutputStream  f = new FileOutputStream(new File(myFolder, urlString));
                InputStream in = c.getInputStream();
                byte[] buffer = new byte[1024];
                int len1 = 0;
                while ((len1 = in.read(buffer)) > 0) {
                    f.write(buffer, 0, len1);
                }
                f.close();
            } catch (IOException e) {
                noErrores++;
                Log.d("Error....", e.toString());
            }
        }

        public void verificar_descargados(Activity vista){
            ImageView img_1= (ImageView) vista.findViewById(R.id.imageView3);
            ImageView img_2= (ImageView) vista.findViewById(R.id.imageView4);
            ImageView img_3= (ImageView) vista.findViewById(R.id.imageView5);
            ImageView img_4= (ImageView) vista.findViewById(R.id.imageView7);
            ImageView img_5= (ImageView) vista.findViewById(R.id.imageView8);
            ImageView img_6= (ImageView) vista.findViewById(R.id.imageView2);

            File file_1 = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM),"VideosSexto");
            if(file_1.exists()){
                img_1.setImageResource(R.drawable.grado6_2);
            }else{
                img_1.setImageResource(R.drawable.grado6);
            }

            File file_2 = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM),"VideosSeptimo");
            if(file_2.exists()){
                img_2.setImageResource(R.drawable.grado7_2);
            }else{
                img_2.setImageResource(R.drawable.grado7);
            }

            File file_3 = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM),"VideosOctavo");
            if(file_3.exists()){
                img_3.setImageResource(R.drawable.grado8_2);
            }else{
                img_3.setImageResource(R.drawable.grado8);
            }

            File file_4 = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM),"VideosNoveno");
            if(file_4.exists()){
                img_4.setImageResource(R.drawable.grado9_2);
            }else{
                img_4.setImageResource(R.drawable.grado9);
            }
            File file_5 = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM),"VideosDecimo");
            if(file_5.exists()){
                img_5.setImageResource(R.drawable.grado10_2);
            }else{
                img_5.setImageResource(R.drawable.grado10);
            }
            File file_6 = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM),"VideosUndecimo");
            if(file_6.exists()){
                img_6.setImageResource(R.drawable.grado11_2);
            }else{
                img_6.setImageResource(R.drawable.grado11);
            }
        }

        protected void onProgressUpdate(Integer... progress) {
            progressDialog.setProgress(progress[0]);
            if (rowItems != null) {
                progressDialog.setMessage("Descargando " + rowItems.size() + " de " + noOfURLs+" videos.");
            }
        }

        @Override
        protected void onPostExecute(Void rowItems) {
            progressDialog.dismiss();

            if(noErrores > 0 && this.tipoDescarga == 0){
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                alertDialogBuilder.setTitle("Proceso completado");
                alertDialogBuilder.setMessage("Se han presentado ("+noErrores+") errores con repecto a los archivos, en el proceso de descarga");
                alertDialogBuilder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }

        }

    }
}