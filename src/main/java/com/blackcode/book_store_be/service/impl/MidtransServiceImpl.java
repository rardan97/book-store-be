package com.blackcode.book_store_be.service.impl;


import com.blackcode.book_store_be.dto.payment.DataProductPembelian;
import com.blackcode.book_store_be.dto.payment.MidtransItemDetails;
import com.blackcode.book_store_be.dto.payment.TransaksiPembelianRequest;
import com.blackcode.book_store_be.service.MidtransService;
import com.midtrans.Midtrans;
import com.midtrans.httpclient.SnapApi;
import com.midtrans.httpclient.error.MidtransError;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MidtransServiceImpl implements MidtransService {

    private static final String SERVER_KEY = "SB-Mid-server-XvehB-i_AbVU0wzoc4or_vep";  // Example: "SB-Mid-client-xxx"
    private static final boolean IS_PRODUCTION = false;

    @Override
    public Map<String, Object> createTransactionToken(TransaksiPembelianRequest transaksiPembelianRequest) throws MidtransError {
        Midtrans.serverKey = SERVER_KEY;
        Midtrans.isProduction = IS_PRODUCTION;

        UUID idRand = UUID.randomUUID();

        // Create parameters for the transaction
        Map<String, Object> params = new HashMap<>();

        Map<String, Object> transactionDetails = getStringObjectMap(transaksiPembelianRequest, idRand);
        List<MidtransItemDetails> dataRtn = getMidtransItemDetails(transaksiPembelianRequest);

        Map<String, String> customerDetails = new HashMap<>();
        customerDetails.put("first_name", "test");
        customerDetails.put("last_name", "claude");

        // Credit card configuration (e.g., to secure the transaction)
        Map<String, String> creditCard = new HashMap<>();
        creditCard.put("secure", "true");

        // Add all parameters to the request body
        params.put("transaction_details", transactionDetails);

        params.put("customer_details", customerDetails);
        params.put("item_details", dataRtn);
        params.put("credit_card", creditCard);

        // Create the transaction token by calling the SnapApi

        Map<String, Object> rtn = new HashMap<>();
        rtn.put("token", SnapApi.createTransactionToken(params));
        rtn.put("transaction_details", transactionDetails);
        rtn.put("customer_details", customerDetails);
        rtn.put("item_details", dataRtn);
        rtn.put("credit_card", creditCard);
        return rtn;
    }

    @NotNull
    private static Map<String, Object> getStringObjectMap(TransaksiPembelianRequest transaksiPembelianRequest, UUID idRand) {
        Map<String, Object> transactionDetails = new HashMap<>();
        transactionDetails.put("order_id", idRand.toString());
        transactionDetails.put("gross_amount", String.valueOf(transaksiPembelianRequest.getDataProductTransaksi().getTransaksiTotal())); // Example amount in the smallest currency unit

        return transactionDetails;
    }

    @NotNull
    private static List<MidtransItemDetails> getMidtransItemDetails(TransaksiPembelianRequest transaksiPembelianRequest) {
        List<MidtransItemDetails> dataRtn = new ArrayList<>();

        for (DataProductPembelian dataProductPembelian : transaksiPembelianRequest.getDataProductPembelian()) {
            Map<String, String> itemDetails = new HashMap<>();
            MidtransItemDetails itemDtl = new MidtransItemDetails();
            itemDtl.setId(String.valueOf(dataProductPembelian.getProductId()));
            itemDtl.setPrice(dataProductPembelian.getProductHarga());
            itemDtl.setQuantity(dataProductPembelian.getProductQty());
            itemDtl.setName(dataProductPembelian.getProductNama());
            dataRtn.add(itemDtl);
        }
        return dataRtn;
    }
}
