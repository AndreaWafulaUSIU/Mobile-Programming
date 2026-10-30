# CAT One – Min/Max (Android, Java + XML)

Package: `com.example.catone` · minSdk 24 · compileSdk 34 · AGP 8.3.2 · Gradle 8.7 · JDK 17

## Build in GitHub Codespaces
1. Push this folder to a new GitHub repository (the `.devcontainer` folder must be at the repo root).
2. Code → Codespaces → Create codespace. Wait for the setup script to finish (about 5 minutes the first time).
3. In the terminal: `gradle assembleDebug`
4. Download `app/build/outputs/apk/debug/app-debug.apk` (right-click → Download).
5. Upload the APK to an online Android emulator (e.g. appetize.io) to run it and take screenshots.
6. Stop the Codespace when done to save your free hours.

## Where each part of the question is answered
| Part | File |
|---|---|
| (i) TableLayout XML | `app/src/main/res/layout/activity_main.xml` |
| (ii) Declare and bind widgets | `MainActivity.java`, top of `onCreate` |
| (iii) Maximum / Minimum click events | `MainActivity.java`, `btnMax` and `btnMin` listeners |
| (iv-a) Jump to second activity | `MainActivity.java`, `btnNext` listener (`Intent` + `startActivity`) |
| (iv-b) Send and display min and max | `MainActivity.java` (`putExtra`) and `Second.java` (`getIntExtra`) |
| Second activity layout | `app/src/main/res/layout/second.xml` |
