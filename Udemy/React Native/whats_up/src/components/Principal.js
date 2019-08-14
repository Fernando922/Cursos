import React, { Component } from 'react'
import { StyleSheet } from 'react-native'
import { TabView, SceneMap } from 'react-native-tab-view'
import TabBarMenu from './TabBarMenu'
import Conversas from './Conversas'
import Contatos from './Contatos'

_renderHeader = props => <TabBarMenu {...props}/>

export default class TabViewExample extends Component {
  state = {
    index: 0,
    routes: [
      { key: 'first', title: 'Conversas' },
      { key: 'second', title: 'Contatos' },
    ],
  };

  render() {
    return (
      <TabView
        navigationState={this.state}
        renderScene={SceneMap({
          first: Conversas,
          second: Contatos,
        })}
        onIndexChange={index => this.setState({ index })}
        renderTabBar={_renderHeader}
      />
    );
  }
}

const styles = StyleSheet.create({
  scene: {
    flex: 1,
  },
});