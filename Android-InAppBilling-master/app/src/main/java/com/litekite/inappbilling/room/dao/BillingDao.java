/*
 * Copyright 2020 LiteKite Startup. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.litekite.inappbilling.room.dao;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

import com.litekite.inappbilling.room.entity.BillingPurchaseDetails;
import com.litekite.inappbilling.room.entity.BillingSkuDetails;
import com.litekite.inappbilling.room.entity.BillingSkuRelatedPurchases;

import java.util.List;

import static com.litekite.inappbilling.billing.BillingConstants.SKU_UNLOCK_APP_FEATURES;

/**
 * DAO class, performs database operations and returns result in the form of Objects.
 *
 * @author Vignesh S
 * @version 1.0, 04/03/2018
 * @see <a href="https://developer.android.com/reference/android/arch/persistence/room/Transaction.html">A
 * Single Transaction Guide</a>
 * @since 1.0
 */
@SuppressWarnings("NullableProblems")
@Dao
public interface BillingDao {

	@Nullable
	@Transaction
	@Query("select * from billing_sku_details where sku_id != '" + SKU_UNLOCK_APP_FEATURES + "'")
	LiveData<List<BillingSkuRelatedPurchases>> getSkuRelatedPurchases();

	@Nullable
	@Query("select * from billing_sku_details where sku_id = :skuID")
	LiveData<BillingSkuDetails> getSkuDetails(@NonNull String skuID);

	@Nullable
	@Query("select exists(select * from billing_purchase_details where sku_id = :skuID)")
	LiveData<Boolean> getIsThisSkuPurchased(@NonNull String skuID);

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	void insertSkuDetails(@NonNull List<BillingSkuDetails> billingSkuDetails);

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	void insertPurchaseDetails(@NonNull List<BillingPurchaseDetails> billingPurchaseDetails);

}