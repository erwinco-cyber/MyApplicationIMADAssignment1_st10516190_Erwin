# 🕐 Social Cues App

A simple Android app built with Kotlin that helps users improve their social interactions by suggesting meaningful actions based on the time of day.

---

## 📖 Purpose

Many people find it difficult to know *when* or *how* to reach out to friends, family, and colleagues. The Social Cues App solves this by giving the user a friendly, context-aware suggestion based on what time of day it is — helping them build stronger relationships through small, consistent gestures.

The app is designed to be as simple as possible: type in a time of day, press Submit, and get a social nudge.

---

## 📱 User Interface

The app consists of a single screen with:

- A **title/message box** at the top that displays the social cue response
- A **text input field** where the user types the time of day
- A **Submit button** that processes the input and displays a suggestion
- A **Reset button** that clears the input and message

> Valid responses appear in **blue**. Invalid inputs are shown in **red** with a prompt to try again.

---

## ✅ Supported Time Inputs

The app accepts the following time-of-day phrases (case-insensitive, spaces and hyphens are ignored):

| Input Phrase | Example Variations |
|---|---|
| `morning` | "Morning", "morning", "MORNING" |
| `midmorning` | "Mid Morning", "mid-morning", "midmorning" |
| `afternoon` | "Afternoon", "after noon" |
| `afternoonsnacktime` | "Afternoon Snack Time", "afternoon-snack-time" |
| `dinner` | "Dinner", "DINNER" |
| `afterdinner` | "After Dinner", "after-dinner" |

> ⚠️ Any other input will display a red error message asking the user to try again.

---

## 💬 Social Cue Suggestions

| Time of Day | Suggested Social Cue |
|---|---|
| `morning` | Send a "Good morning" text to a family member |
| `midmorning` | Reach out to a colleague with a quick "Thank you" |
| `afternoon` | Share a funny meme or interesting link with a friend |
| `afternoonsnacktime` | Send a quick "thinking of you" message |
| `dinner` | Call a friend or relative for a 5-minute catch-up |
| `afterdinner` | Leave a thoughtful comment on a friend's post |

---

## 🧩 How It Works — Core Logic

The main logic lives in the Submit button's click listener. When the user taps **Submit**:

1. The input text is retrieved and **normalised** — converted to lowercase, trimmed of whitespace, and stripped of spaces and hyphens.
2. The normalised string is checked against a series of `if/else if` conditions.
3. The matching suggestion is displayed in the message box in **blue**.
4. If no match is found, an error message is shown in **red**.

```kotlin
submitButton.setOnClickListener {
    messageBox.setTextColor(android.graphics.Color.BLUE)
    messageBox.textSize = 12f

    val userInput = userInputBox.text
        .toString()
        .lowercase()
        .trim()
        .replace(" ", "")
        .replace("-", "")

    if (userInput.contains("afternoonsnacktime")) {
        messageBox.text = "Send a quick 'thinking of you'"
    } else if (userInput.contains("afternoon")) {
        messageBox.text = "Share a funny meme or interesting link with a friend"
    } else if (userInput.contains("midmorning")) {
        messageBox.text = "Reach out to a colleague with a quick 'Thank you'"
    } else if (userInput.contains("morning")) {
        messageBox.text = "Send a 'Good morning' text to a family member"
    } else if (userInput.contains("afterdinner")) {
        messageBox.text = "Leave a thoughtful comment on a friend's post"
    } else if (userInput.contains("dinner")) {
        messageBox.text = "Call a friend or relative for a 5-minute catch-up"
    } else {
        messageBox.setTextColor(android.graphics.Color.RED)
        messageBox.textSize = 14f
        messageBox.text = "You did not enter a valid option, please try again"
    }
}
```

> **Note:** `afternoonsnacktime` is checked *before* `afternoon` intentionally — this ensures the more specific phrase is matched first and not swallowed by the broader condition.

---

## 🚀 Getting Started

### Prerequisites
- Android Studio (latest stable version recommended)
- Android SDK (API level 21+)
- A physical Android device or emulator

### Running the App
1. Clone or download this repository.
2. Open the project in **Android Studio**.
3. Connect a device or start an emulator.
4. Press **Run ▶** to build and launch the app.

---

## 🛠️ Built With

- [Kotlin](https://kotlinlang.org/) — Primary language
- [Android SDK](https://developer.android.com/) — Mobile platform
- XML layouts — UI design

---

## 📌 Future Improvements

- Add more time-of-day options (e.g. `lunchtime`, `evening`, `midnight`)
- Display suggestions with icons or animations
- Add a history log of past suggestions
- Allow users to customise their own social cues

---

## 👤 Author

Made by Erwin Coetzee as a school project to explore Android development with Kotlin and simple user interaction design.

## 👤 Disclosure
This readme was generated with the assistance of claude.ai (Sonnet 4.6)
