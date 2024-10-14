package nl.pancompany.unicorn.adapter.in.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nl.pancompany.unicorn.application.port.in.SetColorUseCase;
import nl.pancompany.unicorn.application.port.in.SetColorUseCase.SetColorCommand;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UnicornController {

    private final SetColorUseCase setColorUseCase;
    private final ObjectMapper objectMapper;

    @PatchMapping(path = "/unicorns/{unicornId}/parts/{partId}")
    public void putPartColor(@PathVariable("unicornId") Long unicornId, @PathVariable("partId") Long partId,
                             @RequestBody JsonPatch patch) throws JsonPatchException, JsonProcessingException {
        log.info("Patch operation successfully started");
        var partialSetColorDto = new SetColorCommand(unicornId, partId, null);
        var fullSetColorDto = patchColor(patch, partialSetColorDto);
        setColorUseCase.colorPart(fullSetColorDto);
        log.info("Patch operation successfully finished");
    }

    private SetColorCommand patchColor(
            JsonPatch patch, SetColorCommand targetCustomer) throws JsonProcessingException, JsonPatchException {
        JsonNode patched = patch.apply(objectMapper.convertValue(targetCustomer, JsonNode.class));
        return objectMapper.treeToValue(patched, SetColorCommand.class);
    }
}
