# HapifyMe UI & API Tests

Repository: https://github.com/AAntonie/HapifyMe-UI--API-Tests

✔ Pipeline trecut cu succes:

![Pipeline status](images/PipeLineGitHub.jpg)

---

## 📌 Descriere
Acest proiect conține teste UI și API pentru aplicația HapifyMe.

---

## 🔄 Test important: User Lifecycle (E2E API Test)

Unul dintre cele mai importante teste din proiect este un test de tip **end-to-end API**, care validează întregul lifecycle al unui utilizator.

### 📌 Scop
Testul verifică întregul flux al unui utilizator:

- înregistrare cont nou
- confirmare email
- autentificare (login)
- citire profil
- actualizare profil
- ștergere cont
- validare acces după ștergere (negative test)

---

## ⏳ Utilizarea ApiPoller în testele API

În cadrul acestui proiect, clasa `ApiPoller` este utilizată în testele API pentru a gestiona scenarii asincrone din backend.

### 📌 Context de utilizare

În fluxul de **User Lifecycle (E2E)**, anumite date nu sunt disponibile imediat după apelurile API.

Un exemplu concret este generarea `confirmation_token` după înregistrarea unui utilizator.

Acest token este creat asincron și nu este returnat imediat în răspunsul de register.

---

### 🔄 Comportament ApiPoller

ApiPoller:

- trimite request-uri repetate către endpoint-ul API  
- verifică dacă valoarea câmpului este disponibilă  
- rulează până la:
  - 20 secunde timeout  
  - 2 secunde polling interval  
- se oprește imediat ce condiția este îndeplinită  

---

### 💡 Beneficii în framework

- elimină utilizarea `Thread.sleep()` (anti-pattern)  
- crește stabilitatea testelor API  
- gestionează corect eventual consistency din backend  
- permite sincronizare inteligentă în teste async  

---

## ⚙️ Instrucțiuni de rulare locală

### Cerințe:
- Java 23
- Maven 3+

---

## 🚀 Pași pentru rulare

```bash id="run_steps"
# 1. Clonează repository-ul
git clone https://github.com/AAntonie/HapifyMe-UI--API-Tests

# 2. Intră în proiect
cd HapifyMe-UI--API-Tests

# 3. Rulează testele
mvn test