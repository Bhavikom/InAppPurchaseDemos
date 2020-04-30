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

package com.litekite.inappbilling.room.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

/**
 * Database Entity, has Schema about Purchase Details.
 *
 * @author Vignesh S
 * @version 1.0, 04/03/2018
 * @since 1.0
 */
@Entity(tableName = "billing_purchase_details",
		indices = @Index("sku_id"))
public class BillingPurchaseDetails {

	@NonNull
	@PrimaryKey
	@ColumnInfo(name = "purchase_token")
	public String purchaseToken = "";

	@NonNull
	@ColumnInfo(name = "order_id")
	public String orderID = "";

	@NonNull
	@ColumnInfo(name = "sku_id")
	public String skuID = "";

	@ColumnInfo(name = "purchase_time")
	public long purchaseTime;

}