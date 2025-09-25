import { StatusBar } from 'expo-status-bar';
import { Dimensions, StyleSheet, Text, View, Image, ImageBackground } from 'react-native';

export default function App() {
  return (
    <View style={styles.container}>
      <ImageBackground
        style = {styles.fondo}
        source={{uri:'https://www.fiftysounds.com/images/graphics/white-low-poly-background-338.jpg'}}
      >
        <Text>Demo Imagen</Text>
        <Image
          style = {styles.foto}
          source={{uri:'https://play-lh.googleusercontent.com/R3oQgp4euQlsXUDaYuMes3K8JGtifoD-wrvHkq6q0xTYcROLiuYPqz3OBTZVWlrTq_k'}}

        />

        <Image
          style = {styles.foto}
          source={require('./assets/icon.png')}
        />

      </ImageBackground>

    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },

  foto:{
    width:200,
    height:200,
  },

  fondo:{
    width:Dimensions.get('window').width,
    height:Dimensions.get('window').height,
    alignContent:'center',
    alignContent:'center',
  },
});
