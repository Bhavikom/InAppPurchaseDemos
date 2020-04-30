package com.android.vending.billing;

import android.annotation.SuppressLint;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

public interface IInAppBillingService extends IInterface {

    abstract class Stub extends Binder implements IInAppBillingService {
        private static final String DESCRIPTOR = "com.android.vending.billing.IInAppBillingService";
        static final int TRANSACTION_consumePurchase = 5;
        static final int TRANSACTION_getBuyIntent = 3;
        static final int TRANSACTION_getBuyIntentExtraParams = 8;
        static final int TRANSACTION_getBuyIntentToReplaceSkus = 7;
        static final int TRANSACTION_getPurchaseHistory = 9;
        static final int TRANSACTION_getPurchases = 4;
        static final int TRANSACTION_getSkuDetails = 2;
        static final int TRANSACTION_isBillingSupported = 1;
        static final int TRANSACTION_isBillingSupportedExtraParams = 10;
        static final int TRANSACTION_stub = 6;

        private static class Proxy implements IInAppBillingService {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public int isBillingSupported(int i, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Bundle getSkuDetails(int i, String str, String str2, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Bundle getBuyIntent(int i, String str, String str2, String str3, String str4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeString(str4);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Bundle getPurchases(int i, String str, String str2, String str3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int consumePurchase(int i, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int stub(int i, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Bundle getBuyIntentToReplaceSkus(int i, String str, List<String> list, String str2, String str3, String str4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeStringList(list);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeString(str4);
                    this.mRemote.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Bundle getBuyIntentExtraParams(int i, String str, String str2, String str3, String str4, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeString(str4);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Bundle getPurchaseHistory(int i, String str, String str2, String str3, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int isBillingSupportedExtraParams(int i, String str, String str2, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IInAppBillingService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IInAppBillingService)) {
                return new Proxy(iBinder);
            }
            return (IInAppBillingService) queryLocalInterface;
        }

        @SuppressLint("WrongConstant")
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                Bundle bundle = null;
                switch (i) {
                    case 1:
                        parcel.enforceInterface(DESCRIPTOR);
                        int isBillingSupported = isBillingSupported(parcel.readInt(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(isBillingSupported);
                        return true;
                    case 2:
                        parcel.enforceInterface(DESCRIPTOR);
                        int readInt = parcel.readInt();
                        String readString = parcel.readString();
                        String readString2 = parcel.readString();
                        if (parcel.readInt() != 0) {
                            bundle = Bundle.CREATOR.createFromParcel(parcel);
                        }
                        Bundle skuDetails = getSkuDetails(readInt, readString, readString2, bundle);
                        parcel2.writeNoException();
                        if (skuDetails != null) {
                            parcel2.writeInt(1);
                            skuDetails.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 3:
                        parcel.enforceInterface(DESCRIPTOR);
                        Bundle buyIntent = getBuyIntent(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        if (buyIntent != null) {
                            parcel2.writeInt(1);
                            buyIntent.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 4:
                        parcel.enforceInterface(DESCRIPTOR);
                        Bundle purchases = getPurchases(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        if (purchases != null) {
                            parcel2.writeInt(1);
                            purchases.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 5:
                        parcel.enforceInterface(DESCRIPTOR);
                        int consumePurchase = consumePurchase(parcel.readInt(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(consumePurchase);
                        return true;
                    case 6:
                        parcel.enforceInterface(DESCRIPTOR);
                        int stub = stub(parcel.readInt(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(stub);
                        return true;
                    case 7:
                        parcel.enforceInterface(DESCRIPTOR);
                        Bundle buyIntentToReplaceSkus = getBuyIntentToReplaceSkus(parcel.readInt(), parcel.readString(), parcel.createStringArrayList(), parcel.readString(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        if (buyIntentToReplaceSkus != null) {
                            parcel2.writeInt(1);
                            buyIntentToReplaceSkus.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 8:
                        parcel.enforceInterface(DESCRIPTOR);
                        int readInt2 = parcel.readInt();
                        String readString3 = parcel.readString();
                        String readString4 = parcel.readString();
                        String readString5 = parcel.readString();
                        String readString6 = parcel.readString();
                        if (parcel.readInt() != 0) {
                            bundle = Bundle.CREATOR.createFromParcel(parcel);
                        }
                        Bundle buyIntentExtraParams = getBuyIntentExtraParams(readInt2, readString3, readString4, readString5, readString6, bundle);
                        parcel2.writeNoException();
                        if (buyIntentExtraParams != null) {
                            parcel2.writeInt(1);
                            buyIntentExtraParams.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 9:
                        parcel.enforceInterface(DESCRIPTOR);
                        int readInt3 = parcel.readInt();
                        String readString7 = parcel.readString();
                        String readString8 = parcel.readString();
                        String readString9 = parcel.readString();
                        if (parcel.readInt() != 0) {
                            bundle = Bundle.CREATOR.createFromParcel(parcel);
                        }
                        Bundle purchaseHistory = getPurchaseHistory(readInt3, readString7, readString8, readString9, bundle);
                        parcel2.writeNoException();
                        if (purchaseHistory != null) {
                            parcel2.writeInt(1);
                            purchaseHistory.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 10:
                        parcel.enforceInterface(DESCRIPTOR);
                        int readInt4 = parcel.readInt();
                        String readString10 = parcel.readString();
                        String readString11 = parcel.readString();
                        if (parcel.readInt() != 0) {
                            bundle = Bundle.CREATOR.createFromParcel(parcel);
                        }
                        int isBillingSupportedExtraParams = isBillingSupportedExtraParams(readInt4, readString10, readString11, bundle);
                        parcel2.writeNoException();
                        parcel2.writeInt(isBillingSupportedExtraParams);
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            } else {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
        }
    }

    int consumePurchase(int i, String str, String str2) throws RemoteException;

    Bundle getBuyIntent(int i, String str, String str2, String str3, String str4) throws RemoteException;

    Bundle getBuyIntentExtraParams(int i, String str, String str2, String str3, String str4, Bundle bundle) throws RemoteException;

    Bundle getBuyIntentToReplaceSkus(int i, String str, List<String> list, String str2, String str3, String str4) throws RemoteException;

    Bundle getPurchaseHistory(int i, String str, String str2, String str3, Bundle bundle) throws RemoteException;

    Bundle getPurchases(int i, String str, String str2, String str3) throws RemoteException;

    Bundle getSkuDetails(int i, String str, String str2, Bundle bundle) throws RemoteException;

    int isBillingSupported(int i, String str, String str2) throws RemoteException;

    int isBillingSupportedExtraParams(int i, String str, String str2, Bundle bundle) throws RemoteException;

    int stub(int i, String str, String str2) throws RemoteException;
}
