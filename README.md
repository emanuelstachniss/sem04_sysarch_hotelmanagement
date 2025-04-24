
# Hotelzimmer-Reservierungssystem

Dieses Projekt implementiert ein Hotelzimmer-Reservierungssystem basierend auf **CQRS (Command Query Responsibility Segregation)** und **Event-Sourcing**. Ziel ist die klare Trennung von zustandsverändernden und lesenden Operationen sowie die Rückverfolgbarkeit sämtlicher Systemzustände durch persistente Events.

---

## 📐 1. Architekturübersicht

Das System besteht aus vier modularen Komponenten, die über REST kommunizieren:

- **Command-Seite (`hotel-command-side`)**  
  Verarbeitet Benutzeraktionen, führt Validierungen durch und generiert Events.

- **Query-Seite (`hotel-query-side`)**  
  Dient der effizienten und performanten Abfrage von Informationen basierend auf spezialisierten Read-Modellen.

- **Event-Bus (`eventbus`)**  
  Verteilt und speichert Events. Zentrale Schnittstelle zur Synchronisation zwischen Command- und Query-Seite.

- **Shared Events (`share-events`)**  
  Gemeinsames Modul zur Definition aller Event-Typen.

**Kommunikationsstruktur:**

- REST-API-Verbindungen zwischen allen Komponenten  
- Synchronisierung über Events, die von der Command-Seite erzeugt und vom Eventbus verteilt werden

---

## 🧰 2. Technologien & Projektstruktur

| Komponente     | Technologie              |
|----------------|--------------------------|
| Sprache        | Java 17+                 |
| Framework      | Quarkus                  |
| Build-Tool     | Gradle (Wrapper vorhanden) |
| API-Dokumentation | Swagger UI            |
| Persistenz     | In-Memory (Commands), relationale DB (Queries, z. B. H2/SQLite) |
| Kommunikation  | REST                     |

**Modulstruktur:**

```
hotel-command-side/
hotel-query-side/
eventbus/
share-events/
```

---

## ⚙️ 3. Funktionale Komponenten

### Commands (`hotel-command-side`)

| Befehl            | Beschreibung |
|-------------------|-------------|
| `BookRoom`        | Bucht ein Zimmer für einen Kunden. Prüft Verfügbarkeit und Kundendaten. |
| `CancelBooking`   | Hebt eine Buchung auf. Nur vor Check-in-Datum möglich. |
| `CreateCustomer`  | Legt einen neuen Kunden mit Name, Adresse, Geburtsdatum an. |
| `UpdateCustomer`  | Aktualisiert vorhandene Kundendaten. |
| `PayBooking`      | Markiert eine Buchung als bezahlt, inkl. Zahlungsart und -zeitpunkt. |

---

### Events (`share-events`, `eventbus`)

- `RoomBookedEvent`
- `BookingCancelledEvent`
- `CustomerCreatedEvent`
- `CustomerUpdatedEvent`
- `BookingPaidEvent`

**Alle Events werden persistiert (Event Store) und bilden die Grundlage für die Read-Modelle.**

---

### Queries (`hotel-query-side`)

| Abfrage           | Beschreibung |
|-------------------|--------------|
| `GetBookings`     | Liefert alle Buchungen im Zeitraum. |
| `GetFreeRooms`    | Gibt verfügbare Zimmer für Zeitraum und Personenanzahl aus. |
| `GetCustomers`    | Listet alle Kunden, optional gefiltert nach Namen. |

Read-Modelle basieren auf Events und werden laufend synchronisiert. Persistenz erfolgt in einer relationalen Datenbank mit flachen, performanten Strukturen.

---

## 🚀 4. Ausführung der Applikation

### Voraussetzungen

- Java 17+
- Gradle (Wrapper ist enthalten)

### Endpunkte

| Komponente     | Adresse                      |
|----------------|------------------------------|
| Command-API    | `http://localhost:8081`      |
| Query-API      | `http://localhost:8082`      |
| Eventbus       | `http://localhost:8080`      |

**Swagger UI:**  
Zugänglich unter `/q/swagger-ui` auf jedem Service-Port.

---

## 🧪 5. Beispiel-Szenario

### Ziel: Buchung eines Zimmers für neuen Kunden

1. Kunde erstellen:  
   `POST /createCustomer`

2. Zimmer buchen:  
   `POST /bookRoom`

3. Buchung bezahlen:  
   `POST /payBooking`

4. Buchung abfragen:  
   `GET /bookings?from=...&to=...`

Der Eventbus verteilt alle relevanten Events zur Synchronisierung der Query-Seite.

---

## 🔁 6. Wiederherstellung & Event-Historie

- Alle Events werden persistiert.
- Read-Modelle können daraus vollständig rekonstruiert werden.
- APIs vorhanden für:
  - Event-Historie anzeigen
  - Neuinitialisierung von Read-Modellen
  - Datenlöschung

---

## 🧩 7. Fazit

Das System demonstriert eine saubere Umsetzung von **CQRS** und **Event-Sourcing** mit klarer Trennung von Zustandsänderung und -abfrage. Die Architektur ist **Domain-Driven**, leicht erweiterbar und erlaubt eine präzise Nachverfolgung des Systemzustands.

---