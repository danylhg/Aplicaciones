import { StyleSheet, View, Text, Modal } from 'react-native';

export default () =>{
  return (
    <Modal
        animationType="slide"
        transparent={true}
        visible={false}
      >
        <View style={styles.center}>
          <View style={styles.modalView}>
            <Text> ❤️❤️ </Text>
          </View>
        </View>
    </Modal>
  );
}

const styles = StyleSheet.create({
  center:{
    flex:1,
    justifyContent:'center',
    alignItems:'center',
  },
  modalView:{
    backgroundColor:"#fbfbfbff",
    borderRadius:10,
    padding:20,
    shadowColor:"#000",
    shadowOffset:{
      width:0,
      height:10,
    },
  }
});