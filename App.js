/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 * @flow
 */

import React, { Component } from 'react';
import PushNotification from 'react-native-push-notification-ce'
import Intercom from 'react-native-intercom'
import {
  Platform,
  StyleSheet,
  Text,
  View
} from 'react-native';

PushNotification.configure({
  senderID: "313917594814",
  onRegister: token => {
    console.log("token", token)
    Intercom.sendTokenToIntercom(token.token)
  },
  onNotification: notification => {
    console.log("notification", notification)
  },
  onError: err => {
    console.log("err", err)
  }
})

PushNotification.localNotification({
  /* Android Only Properties */
  bigText: "My big text that will be shown when notification is expanded", // (optional) default: "message" prop
  subText: "This is a subText", // (optional) default: none
  color: "red", // (optional) default: system default
  vibrate: true, // (optional) default: true
  tag: 'some_tag', // (optional) add tag to message
  group: "group", // (optional) add group to message
  ongoing: false, // (optional) set whether this is an "ongoing" notification

  /* iOS and Android properties */
  title: "My Notification Title", // (optional)
  message: "My Notification Message", // (required)
  playSound: false, // (optional) default: true
  number: '10', // (optional) Valid 32 bit integer specified as string. default: none (Cannot be zero)
});

const instructions = Platform.select({
  ios: 'Press Cmd+R to reload,\n' +
    'Cmd+D or shake for dev menu',
  android: 'Double tap R on your keyboard to reload,\n' +
    'Shake or press menu button for dev menu',
});

type Props = {};
export default class App extends Component<Props> {
  componentDidMount() {
    PushNotification.appStart()
  }
  render() {
    return (
      <View style={styles.container}>
        <Text style={styles.welcome}>
          Welcome to React Native!
        </Text>
        <Text style={styles.instructions}>
          To get started, edit App.js
        </Text>
        <Text style={styles.instructions}>
          {instructions}
        </Text>
      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#F5FCFF',
  },
  welcome: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10,
  },
  instructions: {
    textAlign: 'center',
    color: '#333333',
    marginBottom: 5,
  },
});
