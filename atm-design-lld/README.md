Design ATM Machine

1) Handling cash withdrawal
2) Showing account Balance
3) Supporting Multiple Bank accounts via different bank cards
4) Working in a real-world setting with multple ATMs connected to bank servers


FR - 
1) Card Insertion and Authentication
2) Transation Types -  Withdraws , check balance
3) CashDispensing - Machine manage internal cash availability(Notes inventory)

NFR - 
1) High Availability
2) Security - Data Transmission should be encrypted. PIN must never be stored.
3) Extensibility - Easy to add new features like mini satements, UPI or QR payments
4) Graceful degradation if bank network is down.


Great Idea -  Offline fallback discussion - optional depth
While we don’t support offline mode today, the architecture can evolve to support emergency offline
withdrawals via pre-authorized tokens or smart cards with offline limits — if we ever need it.
This shows future-proof thinking without overengineering.