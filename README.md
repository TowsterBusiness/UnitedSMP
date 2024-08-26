# United SMP Archives

![USMP](ss.png)

This is a collection of items that are indevelopment for a more fun smp! 

fling - click to send flying towards your enemies
wings - more controled wings that regenerage the damage taken and have a limited amount of duablilty
    You can use these to have a more balanced elytra that people can only use for a short period of time. 
wind - flings you backwards out of harms way
domain-expansion - woah a JJK thing. Anyways it gives the player a bounding box that allowes for you and your opponent to have a short 1v1. 

- This item activates on player clicks
- box is not breakable
- There are particles when it activates
- You are blinded so its more mysterious
- People are flung away so people can't charge in to your 1v1

All items are set using the cutom item tag so, the functions wouldn't change if they were renamed or enchanted ect.
In addition, the elytra cannot be enchanted since that would make the durability of the item not a disadvantage anymore.

## What is an SMP?
In Minecraft, "SMP" stands for Survival Multiplayer Server. 
It’s a mode or server type where multiple players can join together in a survival world. Players typically gather resources, build structures, and explore the world while interacting with each other.'

## How to install - [How to Start a Minecraft Server](https://help.minecraft.net/hc/en-us/articles/360058525452-How-to-Setup-a-Minecraft-Java-Edition-Server)

How to Setup a Minecraft: Java Edition Server
Note: This guide shows you how to set up and configure a Minecraft Server. However, doing this requires changing your home network's configuration and is not recommended unless you know what you are doing. If you wish to purchase a small private server for friends, check out Minecraft Realms. If you still wish to set up your own private server, do so at your own risk as we cannot offer support for home networks or privately made servers. 

Here is a guide to help you create a server so your friends can join and play together!  

As a prerequisite, you should make sure you have Java installed and up to date on the computer that will host the server so it can run .jar files. 

1. Go to this website and download the minecraft_server.1.XX.X.jar file (The X’s will be the current version number) 
2. After you have downloaded it, make a folder on your desktop to keep all your server files in. You can name it “Minecraft Server”. 
3. Drag over or copy and paste the .jar file into the Minecraft Server folder. 
4. While you have the file browser open, open command prompt from the start menu.  
5. You can check if Java is installed in command prompt by typing without quotes “java -version”. 
6. To start the server, you will need to change the directory to the location where you have the Minecraft Server folder and the .jar file located in it. 
7. You can find the directory in Windows by simply clicking on the browser directory in file browser here. blobid0.png(The theme and color of your file browser will appear different due to your personalization settings) 
8. Copy this address to your clipboard. 
9. Type without quotes “cd” hit space and then paste the address you just copied, then hit enter.
10. This should look like “cd C:\Users\Admin\Desktop\Minecraft Server”
11. Type the following into your command prompt manually without quotation marks after inputting the directory.
12. Java -jar “name of your jar”.jar
13. Hit enter and after running the command, you will notice a failed to load properties error along with failed to load eula.txt. Do not worry as you will just need to rerun this command once we have configured these files.
14. Back in the Minecraft Server folder open the “eula.txt’ file that has been created with your text editor. Here you will need to set the eula=false to eula=true and save.
15. Put this compilied mod into the mods folder
16. Now you just have to rerun the launch command in the command prompt and the server should be running! Repeat steps 8-9 to launch the server again.
17. To access the items, use /give-united to access them. 

Making sure you are in the Minecraft Server file directory and enter java -jar “your jar name”.jar into command prompts 

You will also need to forward the port listed in server.properties query.port. The default it is 25565 so in your router settings you will need to specify that port to forward. This process will vary from different router manufacturers. If you need assistance in forwarding a port, please refer to your router’s help site/manual. 

By default, if you did not specify anything in the server-ip setting, the server will point to your public IP, this is what other players will need to connect to your server and play with you. 

You can find your public IP by simply typing in your search browser: “What is my public IP?” make sure you look for an IP address that is IPv4, this means it only has three decimals and only contains numbers. 

Once you have your public IP, we STRONGLY urge you to not give it out publicly and advertise with it as giving your public IP out publicly is a security risk to your home network. Only give out your IP to people you would like to play with and trust. 

When a player wants to connect to your server, they will enter your public IP address followed by :25565 into the IP field of the server menu. The full address should look something like this: 12.34.56.78:25565 

If you are the host, you can either connect to it by typing the public IP or by simply typing ‘localhost’ if your server is running on the computer you play Minecraft with.

The distribution of your server can be revealing (since you are exposing your ip adress), but by using domains you can be secure while you do it. 
You can buy domain servers and use those domains to distribute your ip adress, hidden through a domain. This means that your domain is not completely exposed to hackers.
