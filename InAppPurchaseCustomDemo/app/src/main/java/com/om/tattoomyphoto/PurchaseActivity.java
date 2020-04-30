package com.om.tattoomyphoto;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.billingclient.api.AcknowledgePurchaseParams;
import com.android.billingclient.api.AcknowledgePurchaseResponseListener;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingClientStateListener;
import com.android.billingclient.api.BillingFlowParams;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.PurchasesUpdatedListener;
import com.android.billingclient.api.SkuDetails;
import com.android.billingclient.api.SkuDetailsParams;
import com.android.billingclient.api.SkuDetailsResponseListener;
import java.util.ArrayList;
import java.util.List;


public class PurchaseActivity extends AppCompatActivity implements PurchasesUpdatedListener {

    BillingClient billingClient;
    Button btnManaged,btnProduct1,btnProduct2,btnProduct3,btnProduct4;
    List<String> skuList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase);

        /* reserved product id */
        skuList.add("android.test.canceled");
        skuList.add("android.test.purchased");
        skuList.add("android.test.item_unavailable");
        skuList.add("one_time_product");
        skuList.add("one_time_product2");
        skuList.add("one_time_product3");
        skuList.add("one_time_product4");

        setUpBillingClient();
        btnManaged = findViewById(R.id.btn_managed);
        btnProduct1 = findViewById(R.id.btn_prdcut1);
        btnProduct2 = findViewById(R.id.btn_prdcut2);
        btnProduct3 = findViewById(R.id.btn_prdcut3);
        btnProduct4 = findViewById(R.id.btn_prdcut4);



    }
    private void setUpBillingClient(){
        billingClient = BillingClient.newBuilder(this).enablePendingPurchases().setListener(this).build();

        billingClient.startConnection(new BillingClientStateListener() {
            @Override
            public void onBillingSetupFinished(BillingResult billingResult) {
                Log.e(" billing ", " Billing setup finished "+billingResult);
                loadAllSKU();

            }

            @Override
            public void onBillingServiceDisconnected() {
                Log.e(" billing ", " onBillingServiceDisconnected ");
            }
        });
    }
    private void loadAllSKU(){
        if(billingClient.isReady()){
            SkuDetailsParams skuDetailsParams = new SkuDetailsParams().newBuilder().setSkusList(skuList).setType(BillingClient.SkuType.INAPP).build();

            billingClient.querySkuDetailsAsync(skuDetailsParams, new SkuDetailsResponseListener() {
                @Override
                public void onSkuDetailsResponse(BillingResult billingResult, List<SkuDetails> list) {
                    for(SkuDetails skudetail : list){
                        if(skudetail.getSku().equalsIgnoreCase("android.test.purchased")){
                            btnManaged.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    BillingFlowParams billingFlowParams = new BillingFlowParams().newBuilder().setSkuDetails(skudetail).build();
                                    billingClient.launchBillingFlow(PurchaseActivity.this, billingFlowParams);
                                }
                            });

                        }else if(skudetail.getSku().equalsIgnoreCase("one_time_product")){
                            btnProduct1.setText("Product1"+skudetail.getPrice());
                            btnProduct1.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    BillingFlowParams billingFlowParams = new BillingFlowParams().newBuilder().setSkuDetails(skudetail).build();
                                    billingClient.launchBillingFlow(PurchaseActivity.this, billingFlowParams);
                                }
                            });
                        }
                        else if(skudetail.getSku().equalsIgnoreCase("one_time_product2")){
                            btnProduct2.setText("Product2"+skudetail.getPrice());
                            btnProduct2.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    BillingFlowParams billingFlowParams = new BillingFlowParams().newBuilder().setSkuDetails(skudetail).build();
                                    billingClient.launchBillingFlow(PurchaseActivity.this, billingFlowParams);
                                }
                            });
                        }
                        else if(skudetail.getSku().equalsIgnoreCase("one_time_product3")){
                            btnProduct3.setText("Product3"+skudetail.getPrice());
                            btnProduct3.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    BillingFlowParams billingFlowParams = new BillingFlowParams().newBuilder().setSkuDetails(skudetail).build();
                                    billingClient.launchBillingFlow(PurchaseActivity.this, billingFlowParams);
                                }
                            });
                        }
                        else if(skudetail.getSku().equalsIgnoreCase("one_time_product4")){
                            btnProduct4.setText("Product4"+skudetail.getPrice());
                            btnProduct4.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    BillingFlowParams billingFlowParams = new BillingFlowParams().newBuilder().setSkuDetails(skudetail).build();
                                    billingClient.launchBillingFlow(PurchaseActivity.this, billingFlowParams);
                                }
                            });
                        }
                    }
                    getPurchasedItems(BillingClient.SkuType.INAPP);
                }
            });
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onPurchasesUpdated(BillingResult billingResult, @Nullable List<Purchase> list) {
        if(billingResult.getResponseCode() == BillingClient.BillingResponseCode.OK && list != null){
                for(Purchase purchase : list){
                    acknowledgePurchase(purchase.getPurchaseToken());
                }
        }else if(billingResult.getResponseCode() == BillingClient.BillingResponseCode.USER_CANCELED){
            Toast.makeText(this, billingResult.getDebugMessage(), Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, billingResult.getDebugMessage(), Toast.LENGTH_SHORT).show();
        }
    }
    private void acknowledgePurchase(String token){
        AcknowledgePurchaseParams params = AcknowledgePurchaseParams.newBuilder().setPurchaseToken(token).build();

        billingClient.acknowledgePurchase(params, new AcknowledgePurchaseResponseListener() {
            @Override
            public void onAcknowledgePurchaseResponse(BillingResult billingResult) {
                int responseCode = billingResult.getResponseCode();
                String debugMessage = billingResult.getDebugMessage();
                Log.e(" #### "," response code and debug message : " +responseCode + " : "+debugMessage);
            }
        });
    }

    public void getPurchasedItems(@BillingClient.SkuType String skuType) {

        Purchase.PurchasesResult purchasesResult = billingClient.queryPurchases(skuType);

        List<Purchase> purchasedItems = purchasesResult.getPurchasesList();

       for (Purchase purchase : purchasedItems){
           if(purchase.getPurchaseState() == Purchase.PurchaseState.PURCHASED){
               if(purchase.getSku().equalsIgnoreCase("one_time_product")){
                   btnProduct1.setText("Already Purchased");
               }else if(purchase.getSku().equalsIgnoreCase("one_time_product2")){
                   btnProduct2.setText("Already Purchased");
               }else if(purchase.getSku().equalsIgnoreCase("one_time_product3")){
                   btnProduct3.setText("Already Purchased");
               }else if(purchase.getSku().equalsIgnoreCase("one_time_product4")){
                   btnProduct4.setText("Already Purchased");
               }

           }
       }
    }

}
