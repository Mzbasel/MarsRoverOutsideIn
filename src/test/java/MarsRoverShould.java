import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class MarsRoverShould {

    private MarsRover marsRover;
    private String commands;
    private List<CommandType> commandTypeList;
    @Mock
    private CommandFactory commandFactory;
    @Mock
    private CommandParser commandParser;

    @BeforeEach
    public void setUp(){
        marsRover = new MarsRover(commandParser, commandFactory);
        commandTypeList = new ArrayList<>();
    }

    @Test
    public void parse_string_command_to_enum(){
        //given
        commands = "R";

        //when
        marsRover.execute(commands);

        //then
        then(commandParser).should().parse(commands);
    }

    @Test
    public void get_the_list_of_command_type_then_execute_the_commands(){
        //given
        commands = "R";
        commandTypeList = List.of(CommandType.ROTATE_RIGHT);
        given(commandParser.parse(commands)).willReturn(commandTypeList);

        //when
        marsRover.execute(commands);

        //then
        then(commandFactory).should().run(commandTypeList);
    }

    @Test
    public void get_the_list_of_command_type_and_execute_the_commands_then_return_the_final_grid(){
        //given
        commands = "R";
        commandTypeList = List.of(CommandType.ROTATE_RIGHT);
        Grid expectedGrid = new Grid(Direction.EAST, new Coordinates(0,0));
        given(commandParser.parse(commands)).willReturn(commandTypeList);
        given(commandFactory.run(commandTypeList)).willReturn(expectedGrid);

        //when
        Grid actualGrid = marsRover.execute(commands);

        //then
        assertEquals(expectedGrid, actualGrid);
    }

}