import React, { useState } from "react";
import {Text, StyleSheet} from "react-native";

export default () => {
    const [contador, setContador] = useState(0);
    return(

        <> 
            <Text style={styles.texto}
                onPress={() => setContador(contador + 1 ) }
            > 
                +
            </Text>


            <Text style={styles.texto}
            >
                {contador}
            </Text>

            <Text style={styles.texto}
                onPress={() => setContador(contador - 1 ) }
            > 
                -
            </Text>
        </>
    )

}

const styles = StyleSheet.create({
    texto:{
        fontSize: 48,
    },
});