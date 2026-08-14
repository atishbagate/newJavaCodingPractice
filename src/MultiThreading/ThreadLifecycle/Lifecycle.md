# The Story of Thready the Intern

A simple analogy to understand the Java Thread Lifecycle.

---

## Stage 1: `NEW` – The Intern is Hired

You just hired **Thready**. He’s sitting at his desk with his laptop open, and his employee ID badge has been printed, but no one has told him to start working yet.

He is technically part of the company, but he hasn't begun any work.

**Java Code:**

```java
Thread t = new Thread(task);
```

---

## Stage 2: `RUNNABLE` – The Grind Begins

You walk by and say:

> **"Start the project!"**

Thready immediately begins working.

He is now in the **RUNNABLE** state.

He may be:

- Actively executing on the CPU (**Running**), or
- Waiting for CPU time (**Ready**)

Both conditions are represented by the **RUNNABLE** state in Java.

**Java Code:**

```java
t.start();
```

---

## Stage 3: `TIMED_WAITING` – The Coffee Break

Thready needs data from an external server that will take exactly **5 seconds** to respond.

He sets a timer on his phone and relaxes until the time expires.

He isn't working during this period, but he knows exactly when he'll resume.

**Java Code:**

```java
Thread.sleep(5000);
```

---

## Stage 4: `BLOCKED` – The Locked Office

After his coffee break, Thready heads to the **Shared Files Room** to upload his report.

He grabs the doorknob...

🚪 **The door is locked.**

His manager is already inside using the room.

Thready cannot continue until the manager leaves and releases the lock.

This is the **BLOCKED** state.

**Java Code:**

```java
synchronized (sharedResource) {
    // Critical section
}
```

> Thready is waiting to acquire the object's monitor (lock).

---

## Stage 5: `WAITING` – "Call Me When You're Done"

The manager finally leaves, and Thready enters the room.

Now he realizes he can't complete the report until his coworker, **Data-Bot**, sends him the required information.

Instead of checking every second, he simply says:

> **"Notify me when you're done."**

He waits indefinitely until someone wakes him up.

This is the **WAITING** state.

**Java Code:**

```java
sharedResource.wait();
```

---

## Stage 6: `TERMINATED` – Clocking Out

Finally...

Data-Bot sends the notification.

Thready completes the report, saves his work, closes his laptop, and leaves the office.

His job is finished.

He is now in the **TERMINATED** state.

A terminated thread cannot be started again.

**Java Code:**

```java
// The run() method finishes execution.
```

---

# Java Thread Lifecycle Summary


| State           | Real-Life Analogy               | Java Example                     |
| --------------- | ------------------------------- | -------------------------------- |
| `NEW`           | Intern hired but hasn't started | `new Thread(task)`               |
| `RUNNABLE`      | Working or waiting for CPU      | `start()`                        |
| `TIMED_WAITING` | Coffee break for a fixed time   | `sleep(5000)`                    |
| `BLOCKED`       | Waiting outside a locked room   | Waiting for a`synchronized` lock |
| `WAITING`       | Waiting for someone to notify   | `wait()`                         |
| `TERMINATED`    | Work completed, goes home       | `run()` method finishes          |

---

## Easy Memory Trick

```
NEW
  ↓
RUNNABLE
  ↓
TIMED_WAITING
  ↓
BLOCKED
  ↓
WAITING
  ↓
RUNNABLE
  ↓
TERMINATED
```

Think of **Thready the Intern**:

- 🆕 Hired → **NEW**
- 💻 Starts working → **RUNNABLE**
- ☕ Takes a timed coffee break → **TIMED_WAITING**
- 🚪 Waits for a locked room → **BLOCKED**
- 📞 Waits for a coworker's signal → **WAITING**
- 💻 Resumes work → **RUNNABLE**
- 🏁 Finishes and goes home → **TERMINATED**
