package codec.types.field46.field2.types

import codec.FieldCodecs.LLVAR_ANS
import codec.types.WalletData4602XX
import scodec.Codec

case class AppPaymentInstanceId460208(id: String) extends WalletData4602XX

object AppPaymentInstanceId460208 {

  val codec: Codec[AppPaymentInstanceId460208] =
    LLVAR_ANS.as[AppPaymentInstanceId460208]
}
