# Scalatron Sample Bot

This project contains the skeleton of a bot for Scalatron. Players are expected to build upon this skeleton to create their own bots.

The project extends the basic Scalatron template by asking users to implement certain methods which use certain datatypes or constructs.
For example this first release uses [Cats](https://github.com/typelevel/cats) datatypes. 

Why to add this extra boilerplate? The aim is to provide an environment in which developers can use these structures in 'real code'. 
On top of that, it's probably more fun to code a bot that makes your enemies cower in fear while using a new *trick* or *pattern* than to read 10 pages of documentation on them.
We expect that this mixture of *real code* (as in, it does something and I may lose if it fails) along *stuff I should learn* will be of benefit to many.  

Obviously you could remove all these layers and implement a bot ignoring all libraries and datatypes altogether, but then you shouldn't be reading this ;)

## How to package your bot

You most likely want to test this bot locally, ensuring it behaves as you expect. No, seriously, you really want that.
But first you need to package it as a jar file so `Scalatron` can interact with it.

This project uses [sbt-assembly](https://github.com/sbt/sbt-assembly) to build a fat Jar that contains all dependencies. Run:

```
$ sbt assembly
```

And `ScalatronBot.jar` will be located under `target\scala-2.11\` folder. Then follow `Scalatron` instructions to run it in your local `Scalatron` instance.



