import { StyleSheet, Button, View } from "react-native"

export default () =>{
    return (
        <View style={styles.panel}>
            <Button title="Lista"/>
            <Button title="Mostrar/Ocultar"/>
        </View>
    );
}

const styles = StyleSheet.create({
    panel:{
        position: 'absolute',
        bottom: 0,
        width: '100%',
        flexDirection:'row',
        justifyContent:'center',
        alignItems:'center',
        paddingVertical: 20,
    }
});