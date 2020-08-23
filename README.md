# Awesome Dialog - A Beautiful Dialogs Library for Android Kotlin 🤩🔥 

[![platform](https://img.shields.io/badge/platform-Android-yellow.svg)](https://www.android.com)
[![API](https://img.shields.io/badge/API-21%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=21)
[![GitHub license](https://img.shields.io/badge/License-Apache2.0-blue.svg)](LICENSE)
![GitHub stars](https://img.shields.io/github/stars/chnouman/AwesomeDialog?style=social)
![GitHub forks](https://img.shields.io/github/forks/chnouman/AwesomeDialog?label=Fork&style=social)
![Repo size](https://img.shields.io/github/repo-size/chnouman/AwesomeDialog?style=social)
![GitHub follow](https://img.shields.io/github/followers/chnouman?label=Follow&style=social)


A Beautiful Multipurpose Awesome Dialogs Library in Android using Kotlin 😍

---

![Showcase](https://raw.githubusercontent.com/chnouman/awesomedialog/master/art/first.PNG)

![Showcase](https://raw.githubusercontent.com/chnouman/awesomedialog/master/art/second.PNG)

## About

A Beautiful Multipurpose Awesome Dialogs Library in Android using Kotlin. 

## Dependency Project Level

Step 1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:



```
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

```

## Dependency App Level

Add dependency in your app module

```
	dependencies {
	        implementation 'com.github.chnouman:AwesomeDialog:1.0.3'
	}

```
## Simple Dialog 🖐🏼
```
AwesomeDialog.build(this)
                .title("Congratulations")
                .body("Your New Account has been created")
                .onPositive("Go To My Account") {
                    Log.d("TAG", "positive ")
                } 
```

## Dialog With Icon ⌛️ 
```
AwesomeDialog.build(this)
		.title("Congratulations")
                .body("Your New Account has been created")
		.icon(R.drawable.ic_congrts)
                .onPositive("Go To My Account") {
                    Log.d("TAG", "positive ")
                }       
```

## Usage 

# Sample Code for 🌟 

### Icon+Title+Body
```
AwesomeDialog.build(this)
                .title(title)
                .body(body)
                .icon(R.drawable.ic_congrts)                
```

### Output
<img src="https://raw.githubusercontent.com/chnouman/awesomedialog/master/art/Screenshot_1597499149.png" width="250px" />



### Icon+Title+Body+ (+ Button)
```
   AwesomeDialog.build(this)
                .title(title)
                .body(body)
                .icon(R.drawable.ic_congrts)
                .onPositive(goToMyAccount) {
                    Log.d("TAG", "positive ")
                }
```

### Output
<img src="https://raw.githubusercontent.com/chnouman/awesomedialog/master/art/Screenshot_1597499156.png" width="250px" />



### Icon+Title+Body+ (+/- Button)
```
AwesomeDialog.build(this)
                .title(title)
                .body(body)
                .icon(R.drawable.ic_congrts)
                .onPositive(goToMyAccount) {
                    Log.d("TAG", "positive ")
                }
                .onNegative(cancel) {
                    Log.d("TAG", "negative ")
                }
        
```

### Output
<img src="https://raw.githubusercontent.com/chnouman/awesomedialog/master/art/Screenshot_1597499160.png" width="250px" />



### Title+Body+ (- Button)
```
AwesomeDialog.build(this)
                .title(title)
                .body(body)
                .onPositive(goToMyAccount) {
                    Log.d("TAG", "positive ")
                }
```

### Output
<img src="https://raw.githubusercontent.com/chnouman/awesomedialog/master/art/Screenshot_1597499169.png" width="250px" />



### Title+Body+ (+/- Button)
```
       AwesomeDialog.build(this)
                .title(title)
                .body(body)
                .onPositive(goToMyAccount) {
                    Log.d("TAG", "positive ")
                }
                .onNegative(cancel) {
                    Log.d("TAG", "negative ")
                }  

```

### Output
<img src="https://raw.githubusercontent.com/chnouman/awesomedialog/master/art/Screenshot_1597499173.png" width="250px" />


### Title+Body+ (+/- Button) With Backgroud 🌈
```
  AwesomeDialog.build(this)
                .title(
                    title,
                    titleColor = ContextCompat.getColor(this, android.R.color.white)
                )
                .body(
                    body,
                    color = ContextCompat.getColor(this, android.R.color.white)
                )
                .background(R.drawable.layout_rounded_dark_black)
                .onPositive(goToMyAccount) {
                    Log.d("TAG", "positive ")
                }
                .onNegative(cancel) {
                    Log.d("TAG", "negative ")
                }
                
```
### Output
<img src="https://raw.githubusercontent.com/chnouman/awesomedialog/master/art/Screenshot_1597499179.png" width="250px" />


### Custom Coloring 🌈
```
  AwesomeDialog.build(this)
                .title(
                    title,
                    titleColor = ContextCompat.getColor(this, android.R.color.white)
                )
                .body(
                    body,
                    color = ContextCompat.getColor(this, android.R.color.white)
                )
                .icon(R.drawable.ic_congrts)
                .background(R.drawable.layout_rounded_green)
                .onPositive(
                    goToMyAccount,
                    color = R.drawable.layout_rounded_dark_white,
                    textColor = ContextCompat.getColor(this, android.R.color.black)
                ) {
                    Log.d("TAG", "positive ")
                }                
```
### Output
<img src="https://raw.githubusercontent.com/chnouman/awesomedialog/master/art/Screenshot_1597510833.png" width="250px" />

### Positioning
We can customize the Position of Dialog.
```kotlin
POSITIONS.CENTER
POSITIONS.BOTTOM
```
By Default Position is Bottom.

| CENTER | BOTTOM
| :---------------: | :---------------: | 
| <img src="https://github.com/chnouman/AwesomeDialog/blob/master/art/center.gif" align="center" width="25%"/> | <img src="https://github.com/chnouman/AwesomeDialog/blob/master/art/bottom_dialog.gif" align="center" width="25%"/>


## Awesome Attributes Properties
## title()
Parameter | Type | Default Value
--- | --- | --- |
title | String | Empty String
fontStyle |  TypeFace | Android Default
titleColor | Int | Android Default Color



## body()
Parameter | Type | Default Value.
--- | --- | --- |
body      |  String | Empty String.
fontStyle | Typeface | Android Default.
color | Int | Android Default Text Color.

## icon()
Parameter | Type | Default Value
--- | --- | --- |
icon |  Int | Not Null
animateIcon | Boolean | false


## position()
Parameter | Type | Default Value
--- | --- | --- | 
position |  POSITIONS | POSITIONS.BOTTOM

## background()
Parameter | Type | Default Value
--- | --- | --- |
dialogBackgroundColor |  INT | DEFAULT

## onPositive()
Parameter | Type | Default Value
--- | --- | --- | 
text |  String | Empty String
buttonBackgroundColor | Int | Default Color
action | () -> Unit | Empty

## onNegative()
Parameter | Type | Default Value
--- | --- | --- |
text |  String | Empty String
buttonBackgroundColor | Int | Default Color
action | () -> Unit | Empty




## License
```


    Copyright 2020 Muhammad Nouman

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

```
