package codec.types.field46.field3.types

import codec.FieldCodecs.LLVAR_ANS
import codec.types.field46.field3.DeviceData4603XX
import scodec.Codec

case class BluetoothMacAddress460311(value: String) extends DeviceData4603XX

object BluetoothMacAddress460311 {
  val codec: Codec[BluetoothMacAddress460311] = LLVAR_ANS.as[BluetoothMacAddress460311]
}
