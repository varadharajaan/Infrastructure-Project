package com.eventcount.controllers;

import static org.junit.Assert.assertNotNull;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

/**
 *
 * @author eventcount
 */
//@RunWith(SpringRunner.class)
//@WebAppConfiguration
//@SpringBootTest(classes = BasicApplication.class)
public class EventCountControllerTest {
/*
    private MediaType contentType = new MediaType(
            MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8")
    );

    private MockMvc mockMvc;

    private HttpMessageConverter mappingJackson2HttpMessageConverter;

    private List<ToDo> todoList = new ArrayList<>();

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private EventCountRepository todoRepository;

    @Autowired
    void setConverters(HttpMessageConverter<?>[] converters) {

        this.mappingJackson2HttpMessageConverter = Arrays.asList(converters).stream()
                .filter(hmc -> hmc instanceof MappingJackson2HttpMessageConverter)
                .findAny()
                .orElse(null);

        assertNotNull("the JSON message converter must not be null",
                this.mappingJackson2HttpMessageConverter);
    }

    @Before
    public void setup() throws Exception {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();

        this.todoRepository.deleteAllInBatch();
        ToDo toDo1 = new ToDo("varadharajaan@gmail.com","caption 1", "description 1", 5);
        ToDo toDo2 = new ToDo("varadharajan@gmail.com","caption 2", "description 2", 4);

        Attachment attach1 = new Attachment("planilha", "xls");
        Attachment attach2 = new Attachment("phones", "xls");

        Category category = new Category("work");

        Set<Attachment> files = new HashSet<>();
        files.add(attach1);
        files.add(attach2);
        ArrayList categories = new ArrayList(Arrays.asList(
                new Category[]{category})
        );
        toDo1.setAttachments(files);
        toDo1.setCategories(categories);

        this.todoList.add(todoRepository.save(toDo1));
        this.todoList.add(todoRepository.save(toDo2));
        List<ToDo> findAll = todoRepository.findAll();
        findAll.stream().forEach(t -> {
            System.out.println(t.getId() + " ====>>> ");
            t.getCategories().stream().forEach(a -> System.out.println(a.getName()));
        });
    }

    protected String json(Object o) throws IOException {
        MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
        this.mappingJackson2HttpMessageConverter.write(
                o,
                MediaType.APPLICATION_JSON,
                mockHttpOutputMessage
        );
        return mockHttpOutputMessage.getBodyAsString();
    }

    @Test
    public void todoNotFound() throws Exception {
        mockMvc.perform(get("/todos/55")
                .content(this.json(new ToDo()))
                .contentType(contentType))
                .andExpect(status().isNotFound());
    }

    @Test
    public void readSingleEventCount() throws Exception {
        mockMvc.perform(get("/todos/" + this.todoList.get(0).getId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$.id", is(this.todoList.get(0).getId().intValue())))
                .andExpect(jsonPath("$.description", is("description 1")));
    }

    @Test
    public void readEventCounts() throws Exception {
        mockMvc.perform(get("/todos"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(this.todoList.get(0).getId().intValue())))
                .andExpect(jsonPath("$[0].caption", is(this.todoList.get(0).getCaption())))
                .andExpect(jsonPath("$[0].description", is(this.todoList.get(0).getDescription())))
                .andExpect(jsonPath("$[1].id", is(this.todoList.get(1).getId().intValue())))
                .andExpect(jsonPath("$[1].description", is(this.todoList.get(1).getDescription())));
    }

    @Test
    public void createEventCount() throws Exception {
        String todoJson = json(new ToDo("eventcount@gmail.com","caption 1", "description 1", 6));

        ResultActions perform = this.mockMvc.perform(post("/todos")
                .contentType(contentType)
                .content(todoJson));
        perform.andExpect(status().isCreated());
    }
*/

}
