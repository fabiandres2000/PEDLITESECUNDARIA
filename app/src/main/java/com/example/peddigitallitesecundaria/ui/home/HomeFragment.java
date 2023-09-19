package com.example.peddigitallitesecundaria.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.peddigitallitesecundaria.R;
import com.example.peddigitallitesecundaria.databinding.FragmentHomeBinding;

import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    WebView webView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        webView = (WebView) rootView.findViewById(R.id.myWebView);
        WebSettings webSettings = webView.getSettings();
        webSettings.setBuiltInZoomControls(false);
        webSettings.setDisplayZoomControls(false);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAllowFileAccessFromFileURLs(true);
        webSettings.setAllowUniversalAccessFromFileURLs(true);
        webSettings.setAllowFileAccess(true);

        webSettings.setDomStorageEnabled(true);
        webSettings.setCacheMode(WebSettings.LOAD_DEFAULT);
        webSettings.setMediaPlaybackRequiresUserGesture(false);
        webView.loadUrl("file:///android_asset/PEDLITESECUNDARIA/Inicio.html");
        webView.setWebViewClient(new HomeFragment.Callback());
        WebView.setWebContentsDebuggingEnabled(true);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private class Callback extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return false;
        }
    }

    
}