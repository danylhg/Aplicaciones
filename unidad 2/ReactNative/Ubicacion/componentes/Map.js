import MapView from 'react-native-maps';
import { Dimensions, StyleSheet} from 'react-native';

export default ({longPress}) => {
    return (
      <MapView 
        style={styles.mapa}
        onLongPress={longPress}
      >
      </MapView>
    );
}

const styles = StyleSheet.create({
  mapa: {
    width:Dimensions.get('window').width,
    height:Dimensions.get('window').height-120,
  },
});