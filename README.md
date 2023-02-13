# Swing
This library help developers to create and upgrade their softwares easily with swing framework.

## Usage
There are many classes you can use if you need. <br/>
Here it is a sample code.

```java
var builder = new MessageBox.MessageBoxBuilder("Here is a message", "I hope you enjoy this library")
    .setMessageType(JOptionPane.INFORMATION_MESSAGE)
    .setDialogIcon(new ImageIcon("C:\\icon.png"))
    .setMessageFont(new Font("Inter", Font.PLAIN, 14))
    .setBackground(new Color(3, 172, 199));

switch (builder.build().showYesNoCancelDialog()) {
        case 0 -> System.out.println("Selected yes");
        case 1 -> System.out.println("Selected no");
        case 2 -> System.out.println("Selected cancel");
         default -> System.out.println("No selected nothing");
}
```
