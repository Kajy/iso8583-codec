package codec.types.field48.types

import codec.FieldCodecs.LLVAR_N
import codec.types.field48.PrivateData48XX
import scodec.{Codec, TransformSyntax}

case class OriginTransactionReturnCode4805(value: String)
    extends PrivateData48XX

object OriginTransactionReturnCode4805 {
  val codec: Codec[OriginTransactionReturnCode4805] =
    LLVAR_N.as[OriginTransactionReturnCode4805]
}
