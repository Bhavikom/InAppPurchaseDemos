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

package com.litekite.inappbilling.billing;

import androidx.annotation.NonNull;

/**
 * Listener to the updates that happens when purchases list was updated or consumption of the
 * item was finished, updates the Billing Client responses and errors to the implemented classes.
 *
 * @author Vignesh S
 * @version 1.0, 04/03/2018
 * @since 1.0
 */
public interface BillingUpdatesListener {

	/**
	 * Notifies the error messages of Billing Client.
	 *
	 * @param error billing client error message.
	 */
	void onBillingError(@NonNull String error);

}