package codec.types.field46.field1.types

import codec.FieldCodecs.LLVAR_AN
import codec.types.TokenData4601XX
import scodec.{Codec, TransformSyntax}

case class WalletProvisionedToken460112(token: String) extends TokenData4601XX

object WalletProvisionedToken460112 {
  val codec: Codec[WalletProvisionedToken460112] =
    LLVAR_AN.as[WalletProvisionedToken460112]
}
