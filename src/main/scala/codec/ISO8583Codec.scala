package codec

import codec.BitMap.*
import codec.ISO8583Definition.*
import codec.types.ISO8583
import scodec.{
  Codec,
  HListCodecEnrichedWithHListSupport,
  TransformSyntax,
  ValueCodecEnrichedWithHListSupport
}
import scodec.codecs.*

object ISO8583Codec {

  val BITMAP_DECODER: Codec[Fields] = fixedSizeBytes(8, bits)
    .flatZip { bitMap1 =>
      optional(provide(bitMap1.head), fixedSizeBytes(8, bits))
    }
    .as[Fields]

  private val ISO_8583_CODEC: Codec[ISO8583] =
    (MessageType.codec ::
      (BITMAP_DECODER >>:~ { fields =>
        conditional(fields.isPresent(2), PAN) ::
          conditional(fields.isPresent(3), TYPE) ::
          conditional(fields.isPresent(4), ORIGINAL_AMOUNT) ::
          conditional(fields.isPresent(6), AMOUNT) ::
          conditional(fields.isPresent(7), TIME) ::
          conditional(fields.isPresent(10), CONVERSTION_RATE) ::
          conditional(fields.isPresent(11), AUDIT_NB) ::
          conditional(fields.isPresent(12), LOCAL_TIME) ::
          conditional(fields.isPresent(13), LOCAL_DATE) ::
          conditional(fields.isPresent(14), CARD_EXPIRATION_DATE) ::
          conditional(fields.isPresent(15), RECONCILIATION_DATE) ::
          conditional(fields.isPresent(18), MCC) ::
          conditional(fields.isPresent(22), READING_MODE) ::
          conditional(fields.isPresent(23), PAN_SEQUENCE_NB) ::
          conditional(fields.isPresent(25), POS_CONDITION_CODE) ::
          conditional(fields.isPresent(32), ACQUIRING_ID) ::
          conditional(fields.isPresent(37), RETRIEVAL_REF_NB) ::
          conditional(fields.isPresent(38), AUTHORIZATION_NB) ::
          conditional(fields.isPresent(39), RESPONSE_CODE) ::
          conditional(fields.isPresent(41), TERMINAL_ID) ::
          conditional(fields.isPresent(42), ACCEPTOR_ID) ::
          conditional(fields.isPresent(43), ACCEPTOR_NAME_ADDR) ::
          conditional(fields.isPresent(44), ADVICE_ADD_DATA) ::
          conditional(fields.isPresent(46), WALLET_DATA_INFOS) ::
          conditional(fields.isPresent(47), ADDITIONAL_DATA) ::
          conditional(fields.isPresent(48), PRIVATE_DATA)
      })).as[ISO8583]

  val CODEC: Codec[ISO8583] = variableSizeBytesLong(uint32, ISO_8583_CODEC)

}
